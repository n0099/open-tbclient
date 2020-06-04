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
import com.baidu.android.util.media.MimeType;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.ad;
import com.baidu.swan.apps.aq.ag;
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
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private Activity clq;
    private ArrayList<MediaModel> clr = new ArrayList<>();
    public e cls;
    private FrameLayout.LayoutParams clt;
    private int mItemHeight;
    private int mItemWidth;

    public a(Activity activity) {
        this.clq = activity;
        int displayWidth = ag.getDisplayWidth(this.clq);
        int displayHeight = ag.getDisplayHeight(this.clq);
        this.mItemWidth = displayWidth / 4;
        this.mItemHeight = displayHeight / 4;
        this.clt = new FrameLayout.LayoutParams((displayWidth - ag.dip2px(this.clq, 10.0f)) / 4, (displayWidth - ag.dip2px(this.clq, 10.0f)) / 4);
    }

    public void a(e eVar) {
        this.cls = eVar;
    }

    public void setData(ArrayList<MediaModel> arrayList) {
        if (this.clr.size() > 0) {
            this.clr.clear();
        }
        this.clr.addAll(arrayList);
        d.o(this.clr);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return d.mIsShowCamera ? this.clr.size() + 1 : this.clr.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (d.mIsShowCamera) {
            if (i == 0) {
                return null;
            }
            return this.clr.get(i - 1);
        }
        return this.clr.get(i);
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
        C0358a c0358a;
        if (getItemViewType(i) == 0) {
            View inflate = LayoutInflater.from(this.clq).inflate(a.g.swanapp_album_camera_item, (ViewGroup) null, false);
            al(inflate);
            return inflate;
        }
        if (view == null) {
            view = LayoutInflater.from(this.clq).inflate(a.g.swanapp_album_select_item, (ViewGroup) null);
            C0358a c0358a2 = new C0358a(view);
            view.setTag(c0358a2);
            c0358a = c0358a2;
        } else {
            c0358a = (C0358a) view.getTag();
        }
        a(c0358a, view);
        MediaModel mediaModel = (MediaModel) getItem(i);
        if (mediaModel != null) {
            a(mediaModel.getPath(), c0358a);
            a(mediaModel, c0358a, i);
            b(mediaModel, c0358a, i);
            return view;
        }
        return view;
    }

    private void al(View view) {
        view.findViewById(a.f.album_camera_enter).setLayoutParams(this.clt);
        view.setTag(null);
        view.setClickable(true);
        ImageView imageView = (ImageView) view.findViewById(a.f.album_camera_icon);
        if (TextUtils.equals(d.clG, "Image")) {
            imageView.setImageResource(a.e.swanapp_album_camera_item_selector);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.aiP();
                }
            });
            return;
        }
        imageView.setImageResource(a.e.swanapp_album_camera_video_selector);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aiR();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiP() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.cmm) {
            d.lH(d.mMode);
        } else {
            bY(this.clq);
        }
    }

    private void bY(Context context) {
        com.baidu.swan.apps.ad.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ad.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.3
            @Override // com.baidu.swan.apps.ad.b
            public void gY(String str) {
                a.this.aiQ();
            }

            @Override // com.baidu.swan.apps.ad.b
            public void M(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiQ() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.clq, d.cmn, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.4
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void x(File file) {
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                com.baidu.swan.apps.media.chooser.b.e.e(imageModel);
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.ckw);
                bundle.putString("swanAppId", d.cmn);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.aiX());
                bundle.putString("swanTmpPath", d.cmp);
                d.c(a.this.clq, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void lD(String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiR() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.cmm) {
            d.lH(d.mMode);
        } else if (ad.getAvailableExternalMemorySize() < Config.RAVEN_LOG_LIMIT) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.clq.getResources().getString(a.h.swanapp_album_camera_no_storage)).showToast();
        } else {
            bZ(this.clq);
        }
    }

    private void bZ(Context context) {
        com.baidu.swan.apps.ad.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ad.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.5
            @Override // com.baidu.swan.apps.ad.b
            public void gY(String str) {
                a.this.aiS();
            }

            @Override // com.baidu.swan.apps.ad.b
            public void M(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiS() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.clq, d.cmn, d.cmo, d.mIsFrontCamera, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.6
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void x(File file) {
                com.baidu.swan.apps.media.chooser.b.e.e(com.baidu.swan.apps.media.chooser.b.b.y(file));
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.ckw);
                bundle.putString("swanAppId", d.cmn);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.aiX());
                bundle.putString("swanTmpPath", d.cmp);
                d.c(a.this.clq, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void lD(String str) {
            }
        });
    }

    private void a(final MediaModel mediaModel, final C0358a c0358a, final int i) {
        if (com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            c0358a.clB.setImageResource(a.e.swanapp_album_select_icon_bg);
            c0358a.clA.setVisibility(0);
            c0358a.clA.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
        }
        if (d.a(d.mMode, mediaModel)) {
            c0358a.clz.setVisibility(0);
        } else {
            c0358a.clz.setVisibility(8);
        }
        if (com.baidu.swan.apps.media.chooser.b.c.cmk) {
            if (!d.isGif(mediaModel.getPath())) {
                if (d.isLargeImage(mediaModel.getPath())) {
                    c0358a.clE.setText(this.clq.getString(a.h.swanapp_album_large_photo));
                } else {
                    c0358a.clF.setVisibility(8);
                }
            } else {
                c0358a.clE.setText(this.clq.getString(a.h.swanapp_album_gif_photo));
            }
        } else {
            c0358a.clF.setVisibility(8);
        }
        c0358a.clD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, c0358a);
            }
        });
        c0358a.cly.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, i);
            }
        });
    }

    private void b(final MediaModel mediaModel, C0358a c0358a, final int i) {
        if (mediaModel instanceof VideoModel) {
            final VideoModel videoModel = (VideoModel) mediaModel;
            c0358a.clF.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0358a.clF.getLayoutParams();
            if ((videoModel.getDuration() / 3600) / 1000 > 0) {
                layoutParams.width = this.clq.getResources().getDimensionPixelSize(a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.clq.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.clq.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
            c0358a.clF.setLayoutParams(layoutParams);
            c0358a.clE.setText(aX(videoModel.getDuration()));
            c0358a.cly.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.lE(videoModel.getPath()) && !a.this.aY(videoModel.getDuration())) {
                        a.this.a(mediaModel, i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaModel mediaModel, C0358a c0358a) {
        int selectedCount = com.baidu.swan.apps.media.chooser.b.e.getSelectedCount();
        if (!com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            if (selectedCount >= d.cmm) {
                d.lH(d.mMode);
                return;
            } else if (selectedCount > 0 && TextUtils.equals(d.mMode, "single") && !TextUtils.equals(com.baidu.swan.apps.media.chooser.b.e.aiY(), mediaModel.getType())) {
                com.baidu.swan.apps.res.widget.b.d.k(this.clq, a.h.swanapp_album_select_single).showToast();
                return;
            } else {
                c0358a.clB.setImageResource(a.e.swanapp_album_select_icon_bg);
                c0358a.clA.setVisibility(0);
                c0358a.clA.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
                com.baidu.swan.apps.media.chooser.b.e.e(mediaModel);
                c0358a.clC.startAnimation(AnimationUtils.loadAnimation(this.clq, a.C0281a.swanapp_album_checkshake));
                if (this.cls != null) {
                    this.cls.fJ(selectedCount);
                }
                notifyDataSetChanged();
                return;
            }
        }
        com.baidu.swan.apps.media.chooser.b.e.f(mediaModel);
        c0358a.clB.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0358a.clA.setVisibility(8);
        if (this.cls != null) {
            this.cls.fJ(selectedCount);
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
            bundle.putBoolean("compressed", d.ckw);
            bundle.putString("swanAppId", d.cmn);
            bundle.putString("mode", d.mMode);
            bundle.putString("previewFrom", "clickItem");
            bundle.putInt("previewPosition", i);
            d.b(this.clq, bundle);
        }
    }

    private void a(C0358a c0358a, View view) {
        Resources resources = this.clq.getResources();
        view.setBackgroundColor(resources.getColor(a.c.aiapps_white));
        c0358a.cly.setBackgroundColor(resources.getColor(a.c.swanapp_album_item_select_bg));
        c0358a.clA.setTextColor(resources.getColor(a.c.swanapp_album_select_number_color));
        c0358a.clF.setBackground(resources.getDrawable(a.e.swanapp_album_item_duration_bg));
        c0358a.clE.setTextColor(resources.getColor(a.c.aiapps_white));
        c0358a.clz.setBackgroundColor(resources.getColor(a.c.swanapp_album_unenable_shadow_color));
        c0358a.cly.setLayoutParams(this.clt);
        c0358a.clz.setLayoutParams(this.clt);
        c0358a.clz.setVisibility(8);
        c0358a.clA.setVisibility(8);
        c0358a.clD.setVisibility(8);
        c0358a.clF.setVisibility(8);
        c0358a.clD.setVisibility(0);
        c0358a.clB.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0358a.clF.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0358a.clF.getLayoutParams();
        layoutParams.width = this.clq.getResources().getDimensionPixelSize(a.d.swanapp_album_item_tip_width);
        layoutParams.height = this.clq.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
        c0358a.clF.setLayoutParams(layoutParams);
    }

    private void a(String str, C0358a c0358a) {
        ImageRequestBuilder ab = ImageRequestBuilder.ab(Uri.fromFile(new File(str)));
        ab.c(new com.facebook.imagepipeline.common.d((int) (this.mItemWidth / 2.0f), (int) (this.mItemHeight / 2.0f)));
        ab.wq(true);
        ab.a(com.facebook.imagepipeline.common.b.dyo().wi(true).dyw());
        c0358a.cly.setController(com.facebook.drawee.a.a.c.dvt().bb(ab.dCz()).wc(false).c(c0358a.cly.getController()).dwk());
    }

    private String aX(long j) {
        long j2 = j / 1000;
        long j3 = j2 / 3600;
        long j4 = j2 % 3600;
        String format = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 / 60));
        String format2 = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 % 60));
        if (j3 == 0) {
            return this.clq.getString(a.h.swanapp_video_duration, new Object[]{format, format2});
        }
        return this.clq.getString(a.h.swanapp_video_duration_hour, new Object[]{String.format(Locale.getDefault(), "%02d", Long.valueOf(j3)), format, format2});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lE(String str) {
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
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.clq.getString(a.h.swanapp_album_video_format)).showToast();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aY(long j) {
        if (j < 3000) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.clq.getString(a.h.swanapp_album_video_duration_min)).showToast();
            return true;
        } else if (j > 300000) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.clq.getString(a.h.swanapp_album_video_duration_max)).showToast();
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0358a {
        private TextView clA;
        private ImageView clB;
        private View clC;
        private View clD;
        private TextView clE;
        private View clF;
        private SimpleDraweeView cly;
        private ImageView clz;

        public C0358a(View view) {
            this.cly = (SimpleDraweeView) view.findViewById(a.f.album_item_img);
            this.clB = (ImageView) view.findViewById(a.f.album_item_select_checkbox);
            this.clA = (TextView) view.findViewById(a.f.album_item_select_number);
            this.clD = view.findViewById(a.f.album_item_selected_check);
            this.clC = view.findViewById(a.f.album_item_select_circle_view);
            this.clz = (ImageView) view.findViewById(a.f.album_item_unable_shadow);
            this.clF = view.findViewById(a.f.album_item_tip_bg);
            this.clE = (TextView) view.findViewById(a.f.album_item_right_bottom_tip);
        }
    }
}
