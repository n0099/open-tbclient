package com.baidu.swan.apps.media.chooser.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.android.util.media.MimeType;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.af;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.media.chooser.b.d;
import com.baidu.swan.apps.media.chooser.c.e;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.webkit.sdk.PermissionRequest;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private Activity bIs;
    private ArrayList<MediaModel> cWE = new ArrayList<>();
    public e cWF;
    private int mItemHeight;
    private int mItemWidth;
    private FrameLayout.LayoutParams mLayoutParams;

    public a(Activity activity) {
        this.bIs = activity;
        int displayWidth = ah.getDisplayWidth(this.bIs);
        int displayHeight = ah.getDisplayHeight(this.bIs);
        this.mItemWidth = displayWidth / 4;
        this.mItemHeight = displayHeight / 4;
        this.mLayoutParams = new FrameLayout.LayoutParams((displayWidth - ah.dip2px(this.bIs, 10.0f)) / 4, (displayWidth - ah.dip2px(this.bIs, 10.0f)) / 4);
    }

    public void a(e eVar) {
        this.cWF = eVar;
    }

    public void setData(ArrayList<MediaModel> arrayList) {
        if (this.cWE.size() > 0) {
            this.cWE.clear();
        }
        this.cWE.addAll(arrayList);
        d.t(this.cWE);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return d.mIsShowCamera ? this.cWE.size() + 1 : this.cWE.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (d.mIsShowCamera) {
            if (i == 0) {
                return null;
            }
            return this.cWE.get(i - 1);
        }
        return this.cWE.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (d.mIsShowCamera && i == 0) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0441a c0441a;
        if (getItemViewType(i) == 0) {
            View inflate = LayoutInflater.from(this.bIs).inflate(a.g.swanapp_album_camera_item, (ViewGroup) null, false);
            at(inflate);
            return inflate;
        }
        if (view == null) {
            view = LayoutInflater.from(this.bIs).inflate(a.g.swanapp_album_select_item, (ViewGroup) null);
            C0441a c0441a2 = new C0441a(view);
            view.setTag(c0441a2);
            c0441a = c0441a2;
        } else {
            c0441a = (C0441a) view.getTag();
        }
        a(c0441a, view);
        MediaModel mediaModel = (MediaModel) getItem(i);
        if (mediaModel != null) {
            a(mediaModel.getPath(), c0441a);
            a(mediaModel, c0441a, i);
            b(mediaModel, c0441a, i);
            return view;
        }
        return view;
    }

    private void at(View view) {
        view.findViewById(a.f.album_camera_enter).setLayoutParams(this.mLayoutParams);
        view.setTag(null);
        view.setClickable(true);
        ImageView imageView = (ImageView) view.findViewById(a.f.album_camera_icon);
        if (TextUtils.equals(d.cRf, "Image")) {
            imageView.setImageResource(a.e.swanapp_album_camera_item_selector);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.ayn();
                }
            });
            return;
        }
        imageView.setImageResource(a.e.swanapp_album_camera_video_selector);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.ayp();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayn() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.cXw) {
            d.pO(d.mMode);
        } else {
            cn(this.bIs);
        }
    }

    private void cn(Context context) {
        com.baidu.swan.apps.ab.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.3
            @Override // com.baidu.swan.apps.ab.b
            public void ke(String str) {
                a.this.ayo();
            }

            @Override // com.baidu.swan.apps.ab.b
            public void ab(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayo() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.bIs, d.cXx, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.4
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void E(File file) {
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                com.baidu.swan.apps.media.chooser.b.e.e(imageModel);
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.cVM);
                bundle.putString("swanAppId", d.cXx);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.ayv());
                bundle.putString("swanTmpPath", d.cXz);
                d.c(a.this.bIs, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void pK(String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayp() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.cXw) {
            d.pO(d.mMode);
        } else if (af.getAvailableExternalMemorySize() < Config.RAVEN_LOG_LIMIT) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.bIs.getResources().getString(a.h.swanapp_album_camera_no_storage)).showToast();
        } else {
            co(this.bIs);
        }
    }

    private void co(Context context) {
        com.baidu.swan.apps.ab.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.5
            @Override // com.baidu.swan.apps.ab.b
            public void ke(String str) {
                a.this.ayq();
            }

            @Override // com.baidu.swan.apps.ab.b
            public void ab(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayq() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.bIs, d.cXx, d.cXy, d.mIsFrontCamera, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.6
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void E(File file) {
                com.baidu.swan.apps.media.chooser.b.e.e(com.baidu.swan.apps.media.chooser.b.b.F(file));
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.cVM);
                bundle.putString("swanAppId", d.cXx);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.ayv());
                bundle.putString("swanTmpPath", d.cXz);
                d.c(a.this.bIs, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void pK(String str) {
            }
        });
    }

    private void a(final MediaModel mediaModel, final C0441a c0441a, final int i) {
        if (com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            c0441a.cWN.setImageResource(a.e.swanapp_album_select_icon_bg);
            c0441a.cWM.setVisibility(0);
            c0441a.cWM.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
        }
        if (d.a(d.mMode, mediaModel)) {
            c0441a.cWL.setVisibility(0);
        } else {
            c0441a.cWL.setVisibility(8);
        }
        if (com.baidu.swan.apps.media.chooser.b.c.cXu) {
            if (!d.isGif(mediaModel.getPath())) {
                if (d.isLargeImage(mediaModel.getPath())) {
                    c0441a.cWQ.setText(this.bIs.getString(a.h.swanapp_album_large_photo));
                } else {
                    c0441a.cWR.setVisibility(8);
                }
            } else {
                c0441a.cWQ.setText(this.bIs.getString(a.h.swanapp_album_gif_photo));
            }
        } else {
            c0441a.cWR.setVisibility(8);
        }
        c0441a.cWP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, c0441a);
            }
        });
        c0441a.cWK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, i);
            }
        });
    }

    private void b(final MediaModel mediaModel, C0441a c0441a, final int i) {
        if (mediaModel instanceof VideoModel) {
            final VideoModel videoModel = (VideoModel) mediaModel;
            c0441a.cWR.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0441a.cWR.getLayoutParams();
            if ((videoModel.getDuration() / 3600) / 1000 > 0) {
                layoutParams.width = this.bIs.getResources().getDimensionPixelSize(a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.bIs.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.bIs.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
            c0441a.cWR.setLayoutParams(layoutParams);
            c0441a.cWQ.setText(br(videoModel.getDuration()));
            c0441a.cWK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.pL(videoModel.getPath()) && !a.this.bs(videoModel.getDuration())) {
                        a.this.a(mediaModel, i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaModel mediaModel, C0441a c0441a) {
        int selectedCount = com.baidu.swan.apps.media.chooser.b.e.getSelectedCount();
        if (!com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            if (selectedCount >= d.cXw) {
                d.pO(d.mMode);
                return;
            } else if (selectedCount > 0 && TextUtils.equals(d.mMode, "single") && !TextUtils.equals(com.baidu.swan.apps.media.chooser.b.e.ayw(), mediaModel.getType())) {
                com.baidu.swan.apps.res.widget.b.d.k(this.bIs, a.h.swanapp_album_select_single).showToast();
                return;
            } else {
                c0441a.cWN.setImageResource(a.e.swanapp_album_select_icon_bg);
                c0441a.cWM.setVisibility(0);
                c0441a.cWM.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
                com.baidu.swan.apps.media.chooser.b.e.e(mediaModel);
                c0441a.cWO.startAnimation(AnimationUtils.loadAnimation(this.bIs, a.C0357a.swanapp_album_checkshake));
                if (this.cWF != null) {
                    this.cWF.ja(selectedCount);
                }
                notifyDataSetChanged();
                return;
            }
        }
        com.baidu.swan.apps.media.chooser.b.e.f(mediaModel);
        c0441a.cWN.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0441a.cWM.setVisibility(8);
        if (this.cWF != null) {
            this.cWF.ja(selectedCount);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaModel mediaModel, int i) {
        if (!d.a(d.mMode, mediaModel)) {
            if (d.mIsShowCamera) {
                i--;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.cVM);
            bundle.putString("swanAppId", d.cXx);
            bundle.putString("mode", d.mMode);
            bundle.putString("previewFrom", "clickItem");
            bundle.putInt("previewPosition", i);
            d.b(this.bIs, bundle);
        }
    }

    private void a(C0441a c0441a, View view) {
        Resources resources = this.bIs.getResources();
        view.setBackgroundColor(resources.getColor(a.c.aiapps_white));
        c0441a.cWK.setBackgroundColor(resources.getColor(a.c.swanapp_album_item_select_bg));
        c0441a.cWM.setTextColor(resources.getColor(a.c.swanapp_album_select_number_color));
        c0441a.cWR.setBackground(resources.getDrawable(a.e.swanapp_album_item_duration_bg));
        c0441a.cWQ.setTextColor(resources.getColor(a.c.aiapps_white));
        c0441a.cWL.setBackgroundColor(resources.getColor(a.c.swanapp_album_unenable_shadow_color));
        c0441a.cWK.setLayoutParams(this.mLayoutParams);
        c0441a.cWL.setLayoutParams(this.mLayoutParams);
        c0441a.cWL.setVisibility(8);
        c0441a.cWM.setVisibility(8);
        c0441a.cWP.setVisibility(8);
        c0441a.cWR.setVisibility(8);
        c0441a.cWP.setVisibility(0);
        c0441a.cWN.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0441a.cWR.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0441a.cWR.getLayoutParams();
        layoutParams.width = this.bIs.getResources().getDimensionPixelSize(a.d.swanapp_album_item_tip_width);
        layoutParams.height = this.bIs.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
        c0441a.cWR.setLayoutParams(layoutParams);
    }

    private void a(String str, C0441a c0441a) {
        ImageRequestBuilder ad = ImageRequestBuilder.ad(Uri.fromFile(new File(str)));
        ad.c(new com.facebook.imagepipeline.common.d((int) (this.mItemWidth / 2.0f), (int) (this.mItemHeight / 2.0f)));
        ad.Ai(true);
        ad.a(com.facebook.imagepipeline.common.b.ejW().Aa(true).eke());
        c0441a.cWK.setController(com.facebook.drawee.a.a.c.ehd().bn(ad.eoj()).zU(false).c(c0441a.cWK.getController()).ehU());
    }

    private String br(long j) {
        long j2 = j / 1000;
        long j3 = j2 / 3600;
        long j4 = j2 % 3600;
        String format = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 / 60));
        String format2 = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 % 60));
        if (j3 == 0) {
            return this.bIs.getString(a.h.swanapp_video_duration, new Object[]{format, format2});
        }
        return this.bIs.getString(a.h.swanapp_video_duration_hour, new Object[]{String.format(Locale.getDefault(), "%02d", Long.valueOf(j3)), format, format2});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pL(String str) {
        String str2 = "";
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            str2 = mediaMetadataRetriever.extractMetadata(12);
        } catch (Exception e) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str2) && str2.startsWith("video/")) {
            return TextUtils.equals(MimeType.Video.MP4, str2) || TextUtils.equals("video/3gp", str2) || TextUtils.equals("video/webm", str2) || TextUtils.equals("video/mkv", str2);
        }
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.bIs.getString(a.h.swanapp_album_video_format)).showToast();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bs(long j) {
        if (j < IMConnection.RETRY_DELAY_TIMES) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.bIs.getString(a.h.swanapp_album_video_duration_min)).showToast();
            return true;
        } else if (j > 300000) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.bIs.getString(a.h.swanapp_album_video_duration_max)).showToast();
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0441a {
        private SimpleDraweeView cWK;
        private ImageView cWL;
        private TextView cWM;
        private ImageView cWN;
        private View cWO;
        private View cWP;
        private TextView cWQ;
        private View cWR;

        public C0441a(View view) {
            this.cWK = (SimpleDraweeView) view.findViewById(a.f.album_item_img);
            this.cWN = (ImageView) view.findViewById(a.f.album_item_select_checkbox);
            this.cWM = (TextView) view.findViewById(a.f.album_item_select_number);
            this.cWP = view.findViewById(a.f.album_item_selected_check);
            this.cWO = view.findViewById(a.f.album_item_select_circle_view);
            this.cWL = (ImageView) view.findViewById(a.f.album_item_unable_shadow);
            this.cWR = view.findViewById(a.f.album_item_tip_bg);
            this.cWQ = (TextView) view.findViewById(a.f.album_item_right_bottom_tip);
        }
    }
}
