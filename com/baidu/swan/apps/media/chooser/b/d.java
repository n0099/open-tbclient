package com.baidu.swan.apps.media.chooser.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity;
import com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.swan.games.i.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class d {
    public static boolean dgW;
    private static ArrayList<MediaModel> diI;
    public static String diK;
    public static int diL;
    public static String diM;
    public static String dck = "album";
    public static int diJ = 9;
    public static String mMode = "single";
    public static boolean mIsShowCamera = true;
    public static boolean mIsFrontCamera = false;

    public static void t(ArrayList<MediaModel> arrayList) {
        if (diI == null) {
            diI = new ArrayList<>();
        }
        diI.clear();
        diI.addAll(arrayList);
    }

    public static ArrayList<MediaModel> aDv() {
        return diI;
    }

    public static void clear() {
        if (diI != null) {
            diI.clear();
            diI = null;
        }
    }

    public static void a(Context context, Bundle bundle, final com.baidu.swan.apps.media.chooser.c.c cVar) {
        Intent intent = new Intent(context, SwanAppAlbumActivity.class);
        intent.putExtra("launchParams", bundle);
        if (!(context instanceof ActivityResultDispatcherHolder)) {
            cVar.qy("choose: context error");
            return;
        }
        ActivityResultDispatcher resultDispatcher = ((ActivityResultDispatcherHolder) context).getResultDispatcher();
        if (resultDispatcher == null) {
            cVar.qy("choose: ActivityResultDispatcher null");
            return;
        }
        resultDispatcher.addConsumer(new ActivityResultConsumer() { // from class: com.baidu.swan.apps.media.chooser.b.d.1
            @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
            public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent2) {
                com.baidu.swan.apps.v.f.aCp().aBQ();
                if (i == -1) {
                    if (intent2 == null) {
                        com.baidu.swan.apps.media.chooser.c.c.this.qy("choose: Selected data is null");
                        return true;
                    }
                    com.baidu.swan.apps.media.chooser.c.c.this.aK(intent2.getParcelableArrayListExtra("mediaModels"));
                    return true;
                } else if (i == 0) {
                    com.baidu.swan.apps.media.chooser.c.c.this.qy("选择文件失败：用户取消操作");
                    return true;
                } else {
                    return true;
                }
            }
        });
        com.baidu.swan.apps.v.f.aCp().aBP();
        resultDispatcher.startActivityForResult(intent);
        ((Activity) context).overridePendingTransition(a.C0379a.swanapp_album_slide_bottom_in, 0);
    }

    public static JSONObject a(List<MediaModel> list, com.baidu.swan.apps.runtime.e eVar, String str) {
        String cI;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            for (MediaModel mediaModel : list) {
                if (mediaModel != null) {
                    if (eVar.aKn()) {
                        cI = n.xF(mediaModel.aDB());
                    } else {
                        cI = com.baidu.swan.apps.storage.b.cI(mediaModel.aDB(), eVar.id);
                    }
                    jSONArray.put(cI);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("path", cI);
                    if (TextUtils.equals("album", str)) {
                        jSONObject2.put("type", mediaModel.getType());
                    }
                    jSONObject2.put("size", mediaModel.getSize());
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
        String cI;
        if (list == null || !(list.get(0) instanceof VideoModel)) {
            return null;
        }
        VideoModel videoModel = (VideoModel) list.get(0);
        if (eVar.aKn()) {
            cI = n.xF(videoModel.aDB());
        } else {
            cI = com.baidu.swan.apps.storage.b.cI(videoModel.aDB(), eVar.id);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tempFilePath", cI);
            jSONObject.put("duration", videoModel.getDuration() / 1000);
            jSONObject.put("height", videoModel.getHeight());
            jSONObject.put("width", videoModel.getWidth());
            jSONObject.put("size", videoModel.getSize());
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
        activity.startActivityForResult(intent, UgcConstant.LOCAL_PREVIEW_REQUEST);
        activity.overridePendingTransition(a.C0379a.swanapp_album_preview_enter, a.C0379a.aiapps_hold);
    }

    public static void c(final Activity activity, Bundle bundle) {
        if (c.DEBUG) {
            Log.d("SwanAppChooseHelper", "selectCompleted");
        }
        if (e.getSelectedCount() > 0) {
            com.baidu.swan.apps.t.a.azq().a(activity, bundle, new com.baidu.swan.apps.media.chooser.c.d() { // from class: com.baidu.swan.apps.media.chooser.b.d.2
                @Override // com.baidu.swan.apps.media.chooser.c.d
                public void a(boolean z, String str, Object obj) {
                    if (z && (obj instanceof ArrayList)) {
                        ArrayList<? extends Parcelable> arrayList = (ArrayList) obj;
                        if (c.DEBUG) {
                            Iterator<? extends Parcelable> it = arrayList.iterator();
                            while (it.hasNext()) {
                                Log.d("SwanAppChooseHelper", "tempPath = " + ((MediaModel) it.next()).aDB());
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
            com.baidu.swan.apps.t.a.azq().a(activity, bundle, dVar);
        }
    }

    public static boolean a(String str, MediaModel mediaModel) {
        if (e.getSelectedCount() < diJ || e.c(mediaModel)) {
            return TextUtils.equals(str, "single") && e.getSelectedCount() > 0 && !TextUtils.equals(e.aDx(), mediaModel.getType());
        }
        return true;
    }

    public static void qD(String str) {
        if (e.getSelectedCount() != 0) {
            Context appContext = AppRuntime.getAppContext();
            String string = appContext.getString(a.h.swanapp_album_selected_max_files, Integer.valueOf(diJ));
            if (TextUtils.equals(str, "single")) {
                if (e.aDw().get(0) instanceof ImageModel) {
                    string = appContext.getString(a.h.swanapp_album_selected_max_photos, Integer.valueOf(diJ));
                } else {
                    string = appContext.getString(a.h.swanapp_album_selected_max_videos, Integer.valueOf(diJ));
                }
            } else if (TextUtils.equals(str, com.baidu.sapi2.utils.enums.a.c)) {
                string = appContext.getString(a.h.swanapp_album_selected_max_files, Integer.valueOf(diJ));
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

    public static String ae(Context context, String str) {
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
