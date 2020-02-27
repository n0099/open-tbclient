package com.baidu.swan.apps.media.chooser.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity;
import com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.swan.games.h.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    public static boolean bBt;
    private static ArrayList<MediaModel> bCR;
    public static String bCS;
    public static int bCT;
    public static String bCU;
    public static String bCp = "album";
    public static int mMaxSelected = 9;
    public static String mMode = "single";
    public static boolean mIsShowCamera = true;
    public static boolean mIsFrontCamera = false;

    public static void o(ArrayList<MediaModel> arrayList) {
        if (bCR == null) {
            bCR = new ArrayList<>();
        }
        bCR.clear();
        bCR.addAll(arrayList);
    }

    public static ArrayList<MediaModel> XG() {
        return bCR;
    }

    public static void clear() {
        if (bCR != null) {
            bCR.clear();
            bCR = null;
        }
    }

    public static void a(Context context, Bundle bundle, final com.baidu.swan.apps.media.chooser.c.c cVar) {
        Intent intent = new Intent(context, SwanAppAlbumActivity.class);
        intent.putExtra("launchParams", bundle);
        if (!(context instanceof ActivityResultDispatcherHolder)) {
            cVar.jd("choose: context error");
            return;
        }
        ActivityResultDispatcher resultDispatcher = ((ActivityResultDispatcherHolder) context).getResultDispatcher();
        if (resultDispatcher == null) {
            cVar.jd("choose: ActivityResultDispatcher null");
            return;
        }
        resultDispatcher.addConsumer(new ActivityResultConsumer() { // from class: com.baidu.swan.apps.media.chooser.b.d.1
            @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
            public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent2) {
                com.baidu.swan.apps.y.f.WQ().Ws();
                if (i == -1) {
                    if (intent2 == null) {
                        com.baidu.swan.apps.media.chooser.c.c.this.jd("choose: Selected data is null");
                        return true;
                    }
                    com.baidu.swan.apps.media.chooser.c.c.this.U(intent2.getParcelableArrayListExtra("mediaModels"));
                    return true;
                } else if (i == 0) {
                    com.baidu.swan.apps.media.chooser.c.c.this.jd("选择文件失败：用户取消操作");
                    return true;
                } else {
                    return true;
                }
            }
        });
        com.baidu.swan.apps.y.f.WQ().Wr();
        resultDispatcher.startActivityForResult(intent);
        ((Activity) context).overridePendingTransition(a.C0197a.swanapp_album_slide_bottom_in, 0);
    }

    public static JSONObject a(List<MediaModel> list, com.baidu.swan.apps.runtime.e eVar, String str) {
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            for (MediaModel mediaModel : list) {
                if (mediaModel != null) {
                    String rh = com.baidu.swan.d.c.rh(mediaModel.XK());
                    if (eVar.acU()) {
                        str2 = l.pe(mediaModel.XK());
                    } else {
                        str2 = com.baidu.swan.apps.storage.b.br(mediaModel.XK(), eVar.id) + "." + rh;
                    }
                    jSONArray.put(str2);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("path", str2);
                    if (TextUtils.equals("album", str)) {
                        jSONObject2.put("type", mediaModel.getType());
                    }
                    jSONObject2.put(TiebaInitialize.LogFields.SIZE, mediaModel.getSize());
                    if (mediaModel instanceof VideoModel) {
                        VideoModel videoModel = (VideoModel) mediaModel;
                        jSONObject2.put("duration", videoModel.getDuration());
                        jSONObject2.put("height", videoModel.getHeight());
                        jSONObject2.put("width", videoModel.getWidth());
                    }
                    jSONArray2.put(jSONObject2);
                }
            }
            jSONObject.put("tempFilePaths", jSONArray);
            jSONObject.put("tempFiles", jSONArray2);
        } catch (JSONException e) {
            if (c.DEBUG) {
                e.printStackTrace();
            }
        }
        if (c.DEBUG) {
            Log.d("SwanAppChooseHelper", jSONObject.toString());
        }
        return jSONObject;
    }

    public static JSONObject a(List<MediaModel> list, com.baidu.swan.apps.runtime.e eVar) {
        String str;
        if (list == null || !(list.get(0) instanceof VideoModel)) {
            return null;
        }
        VideoModel videoModel = (VideoModel) list.get(0);
        String rh = com.baidu.swan.d.c.rh(videoModel.XK());
        if (eVar.acU()) {
            str = l.pe(videoModel.XK());
        } else {
            str = com.baidu.swan.apps.storage.b.br(videoModel.XK(), eVar.id) + "." + rh;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tempFilePath", str);
            jSONObject.put("duration", videoModel.getDuration() / 1000);
            jSONObject.put("height", videoModel.getHeight());
            jSONObject.put("width", videoModel.getWidth());
            jSONObject.put(TiebaInitialize.LogFields.SIZE, videoModel.getSize());
        } catch (JSONException e) {
            if (c.DEBUG) {
                e.printStackTrace();
            }
        }
        if (c.DEBUG) {
            Log.d("SwanAppChooseHelper", jSONObject.toString());
        }
        return jSONObject;
    }

    public static void b(Activity activity, Bundle bundle) {
        Intent intent = new Intent(activity, SwanAppAlbumPreviewActivity.class);
        intent.putExtra("launchParams", bundle);
        activity.startActivityForResult(intent, 32770);
        activity.overridePendingTransition(a.C0197a.swanapp_album_preview_enter, a.C0197a.aiapps_hold);
    }

    public static void c(final Activity activity, Bundle bundle) {
        if (c.DEBUG) {
            Log.d("SwanAppChooseHelper", "selectCompleted");
        }
        if (e.getSelectedCount() > 0) {
            com.baidu.swan.apps.w.a.Ul().a(activity, bundle, new com.baidu.swan.apps.media.chooser.c.d() { // from class: com.baidu.swan.apps.media.chooser.b.d.2
                @Override // com.baidu.swan.apps.media.chooser.c.d
                public void onResult(boolean z, String str, Object obj) {
                    if (z && (obj instanceof ArrayList)) {
                        ArrayList<? extends Parcelable> arrayList = (ArrayList) obj;
                        if (c.DEBUG) {
                            Iterator<? extends Parcelable> it = arrayList.iterator();
                            while (it.hasNext()) {
                                Log.d(getClass().getSimpleName(), "tempPath = " + ((MediaModel) it.next()).XK());
                            }
                        }
                        Intent intent = new Intent();
                        intent.putParcelableArrayListExtra("mediaModels", arrayList);
                        activity.setResult(-1, intent);
                        activity.finish();
                    }
                }
            });
        }
    }

    public static void b(Activity activity, Bundle bundle, com.baidu.swan.apps.media.chooser.c.d dVar) {
        if (c.DEBUG) {
            Log.d("SwanAppChooseHelper", "selectCompleted");
        }
        if (e.getSelectedCount() > 0) {
            com.baidu.swan.apps.w.a.Ul().a(activity, bundle, dVar);
        }
    }

    public static boolean a(String str, MediaModel mediaModel) {
        if (e.getSelectedCount() < mMaxSelected || e.c(mediaModel)) {
            return TextUtils.equals(str, "single") && e.getSelectedCount() > 0 && !TextUtils.equals(e.XI(), mediaModel.getType());
        }
        return true;
    }

    public static void ji(String str) {
        if (e.getSelectedCount() != 0) {
            Context appContext = AppRuntime.getAppContext();
            String string = appContext.getString(a.h.swanapp_album_selected_max_files, Integer.valueOf(mMaxSelected));
            if (TextUtils.equals(str, "single")) {
                if (e.XH().get(0) instanceof ImageModel) {
                    string = appContext.getString(a.h.swanapp_album_selected_max_photos, Integer.valueOf(mMaxSelected));
                } else {
                    string = appContext.getString(a.h.swanapp_album_selected_max_videos, Integer.valueOf(mMaxSelected));
                }
            } else if (TextUtils.equals(str, com.baidu.sapi2.utils.enums.a.c)) {
                string = appContext.getString(a.h.swanapp_album_selected_max_files, Integer.valueOf(mMaxSelected));
            }
            com.baidu.swan.apps.res.widget.b.d.a(appContext, string).showToast();
        }
    }

    public static boolean isLargeImage(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        float f = options.outWidth;
        float f2 = options.outHeight;
        if (isGif(str) || f <= c.MIN_LARGE_IMG_SCALE || f2 <= c.MIN_LARGE_IMG_SCALE) {
            return false;
        }
        float f3 = f / f2;
        return f3 > c.MIN_LARGE_IMG_RATIO || 1.0f / f3 > c.MIN_LARGE_IMG_RATIO;
    }

    public static boolean isGif(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        String str2 = options.outMimeType;
        return !TextUtils.isEmpty(str2) && str2.equalsIgnoreCase("image/gif");
    }

    public static String am(Context context, String str) {
        int i;
        char c = 65535;
        switch (str.hashCode()) {
            case 70760763:
                if (str.equals("Image")) {
                    c = 0;
                    break;
                }
                break;
            case 92896879:
                if (str.equals("album")) {
                    c = 2;
                    break;
                }
                break;
            case 112202875:
                if (str.equals("video")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                i = a.h.swanapp_album_all_images;
                break;
            case 1:
                i = a.h.swanapp_album_all_videos;
                break;
            case 2:
                i = a.h.swanapp_album_all_media;
                break;
            default:
                i = a.h.swanapp_album_all_media;
                break;
        }
        return context.getResources().getString(i);
    }
}
