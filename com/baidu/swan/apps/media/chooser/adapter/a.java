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
import com.baidu.swan.apps.as.ac;
import com.baidu.swan.apps.as.af;
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
    private ArrayList<MediaModel> bxV = new ArrayList<>();
    public e bxW;
    private FrameLayout.LayoutParams bxX;
    private Activity mContext;
    private int mItemHeight;
    private int mItemWidth;

    public a(Activity activity) {
        this.mContext = activity;
        int displayWidth = af.getDisplayWidth(this.mContext);
        int displayHeight = af.getDisplayHeight(this.mContext);
        this.mItemWidth = displayWidth / 4;
        this.mItemHeight = displayHeight / 4;
        this.bxX = new FrameLayout.LayoutParams((displayWidth - af.dip2px(this.mContext, 10.0f)) / 4, (displayWidth - af.dip2px(this.mContext, 10.0f)) / 4);
    }

    public void a(e eVar) {
        this.bxW = eVar;
    }

    public void setData(ArrayList<MediaModel> arrayList) {
        if (this.bxV.size() > 0) {
            this.bxV.clear();
        }
        this.bxV.addAll(arrayList);
        d.m(this.bxV);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return d.mIsShowCamera ? this.bxV.size() + 1 : this.bxV.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (d.mIsShowCamera) {
            if (i == 0) {
                return null;
            }
            return this.bxV.get(i - 1);
        }
        return this.bxV.get(i);
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
        C0256a c0256a;
        if (getItemViewType(i) == 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(a.g.swanapp_album_camera_item, (ViewGroup) null, false);
            ak(inflate);
            return inflate;
        }
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.swanapp_album_select_item, (ViewGroup) null);
            C0256a c0256a2 = new C0256a(view);
            view.setTag(c0256a2);
            c0256a = c0256a2;
        } else {
            c0256a = (C0256a) view.getTag();
        }
        a(c0256a, view);
        MediaModel mediaModel = (MediaModel) getItem(i);
        if (mediaModel != null) {
            a(mediaModel.getPath(), c0256a);
            a(mediaModel, c0256a, i);
            b(mediaModel, c0256a, i);
            return view;
        }
        return view;
    }

    private void ak(View view) {
        view.findViewById(a.f.album_camera_enter).setLayoutParams(this.bxX);
        view.setTag(null);
        view.setClickable(true);
        ImageView imageView = (ImageView) view.findViewById(a.f.album_camera_icon);
        if (TextUtils.equals(d.byi, "Image")) {
            imageView.setImageResource(a.e.swanapp_album_camera_item_selector);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.Vl();
                }
            });
            return;
        }
        imageView.setImageResource(a.e.swanapp_album_camera_video_selector);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.Vn();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vl() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.mMaxSelected) {
            d.iT(d.mMode);
        } else {
            ci(this.mContext);
        }
    }

    private void ci(Context context) {
        com.baidu.swan.apps.af.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.af.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.3
            @Override // com.baidu.swan.apps.af.b
            public void fo(String str) {
                a.this.Vm();
            }

            @Override // com.baidu.swan.apps.af.b
            public void t(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vm() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.mContext, d.byL, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.4
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void r(File file) {
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                com.baidu.swan.apps.media.chooser.b.e.e(imageModel);
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.bxm);
                bundle.putString("swanAppId", d.byL);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.Vt());
                bundle.putString("swanTmpPath", d.byN);
                d.c(a.this.mContext, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void iP(String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vn() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.mMaxSelected) {
            d.iT(d.mMode);
        } else if (ac.getAvailableExternalMemorySize() < Config.RAVEN_LOG_LIMIT) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.mContext.getResources().getString(a.h.swanapp_album_camera_no_storage)).showToast();
        } else {
            cj(this.mContext);
        }
    }

    private void cj(Context context) {
        com.baidu.swan.apps.af.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.af.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.5
            @Override // com.baidu.swan.apps.af.b
            public void fo(String str) {
                a.this.Vo();
            }

            @Override // com.baidu.swan.apps.af.b
            public void t(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vo() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.mContext, d.byL, d.byM, d.mIsFrontCamera, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.6
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void r(File file) {
                com.baidu.swan.apps.media.chooser.b.e.e(com.baidu.swan.apps.media.chooser.b.b.s(file));
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.bxm);
                bundle.putString("swanAppId", d.byL);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.Vt());
                bundle.putString("swanTmpPath", d.byN);
                d.c(a.this.mContext, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void iP(String str) {
            }
        });
    }

    private void a(final MediaModel mediaModel, final C0256a c0256a, final int i) {
        if (com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            c0256a.byf.setImageResource(a.e.swanapp_album_select_icon_bg);
            c0256a.bye.setVisibility(0);
            c0256a.bye.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
        }
        if (d.a(d.mMode, mediaModel)) {
            c0256a.byd.setVisibility(0);
        } else {
            c0256a.byd.setVisibility(8);
        }
        if (com.baidu.swan.apps.media.chooser.b.c.byJ) {
            if (!d.isGif(mediaModel.getPath())) {
                if (d.isLargeImage(mediaModel.getPath())) {
                    c0256a.byh.setText(this.mContext.getString(a.h.swanapp_album_large_photo));
                } else {
                    c0256a.rightBottomTipBg.setVisibility(8);
                }
            } else {
                c0256a.byh.setText(this.mContext.getString(a.h.swanapp_album_gif_photo));
            }
        } else {
            c0256a.rightBottomTipBg.setVisibility(8);
        }
        c0256a.selectView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, c0256a);
            }
        });
        c0256a.byc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, i);
            }
        });
    }

    private void b(final MediaModel mediaModel, C0256a c0256a, final int i) {
        if (mediaModel instanceof VideoModel) {
            final VideoModel videoModel = (VideoModel) mediaModel;
            c0256a.rightBottomTipBg.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0256a.rightBottomTipBg.getLayoutParams();
            if ((videoModel.getDuration() / 3600) / 1000 > 0) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
            c0256a.rightBottomTipBg.setLayoutParams(layoutParams);
            c0256a.byh.setText(ai(videoModel.getDuration()));
            c0256a.byc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.iQ(videoModel.getPath()) && !a.this.aj(videoModel.getDuration())) {
                        a.this.a(mediaModel, i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaModel mediaModel, C0256a c0256a) {
        int selectedCount = com.baidu.swan.apps.media.chooser.b.e.getSelectedCount();
        if (!com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            if (selectedCount >= d.mMaxSelected) {
                d.iT(d.mMode);
                return;
            } else if (selectedCount > 0 && TextUtils.equals(d.mMode, "single") && !TextUtils.equals(com.baidu.swan.apps.media.chooser.b.e.Vu(), mediaModel.getType())) {
                com.baidu.swan.apps.res.widget.b.d.q(this.mContext, a.h.swanapp_album_select_single).showToast();
                return;
            } else {
                c0256a.byf.setImageResource(a.e.swanapp_album_select_icon_bg);
                c0256a.bye.setVisibility(0);
                c0256a.bye.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
                com.baidu.swan.apps.media.chooser.b.e.e(mediaModel);
                c0256a.byg.startAnimation(AnimationUtils.loadAnimation(this.mContext, a.C0187a.swanapp_album_checkshake));
                if (this.bxW != null) {
                    this.bxW.selectChanged(selectedCount);
                }
                notifyDataSetChanged();
                return;
            }
        }
        com.baidu.swan.apps.media.chooser.b.e.f(mediaModel);
        c0256a.byf.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0256a.bye.setVisibility(8);
        if (this.bxW != null) {
            this.bxW.selectChanged(selectedCount);
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
            bundle.putBoolean("compressed", d.bxm);
            bundle.putString("swanAppId", d.byL);
            bundle.putString("mode", d.mMode);
            bundle.putString("previewFrom", "clickItem");
            bundle.putInt("previewPosition", i);
            d.b(this.mContext, bundle);
        }
    }

    private void a(C0256a c0256a, View view) {
        Resources resources = this.mContext.getResources();
        view.setBackgroundColor(resources.getColor(a.c.aiapps_white));
        c0256a.byc.setBackgroundColor(resources.getColor(a.c.swanapp_album_item_select_bg));
        c0256a.bye.setTextColor(resources.getColor(a.c.swanapp_album_select_number_color));
        c0256a.rightBottomTipBg.setBackground(resources.getDrawable(a.e.swanapp_album_item_duration_bg));
        c0256a.byh.setTextColor(resources.getColor(a.c.aiapps_white));
        c0256a.byd.setBackgroundColor(resources.getColor(a.c.swanapp_album_unenable_shadow_color));
        c0256a.byc.setLayoutParams(this.bxX);
        c0256a.byd.setLayoutParams(this.bxX);
        c0256a.byd.setVisibility(8);
        c0256a.bye.setVisibility(8);
        c0256a.selectView.setVisibility(8);
        c0256a.rightBottomTipBg.setVisibility(8);
        c0256a.selectView.setVisibility(0);
        c0256a.byf.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0256a.rightBottomTipBg.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0256a.rightBottomTipBg.getLayoutParams();
        layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_tip_width);
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
        c0256a.rightBottomTipBg.setLayoutParams(layoutParams);
    }

    private void a(String str, C0256a c0256a) {
        ImageRequestBuilder X = ImageRequestBuilder.X(Uri.fromFile(new File(str)));
        X.c(new com.facebook.imagepipeline.common.d((int) (this.mItemWidth / 2.0f), (int) (this.mItemHeight / 2.0f)));
        X.vs(true);
        X.a(com.facebook.imagepipeline.common.b.dmY().vk(true).dng());
        c0256a.byc.setController(com.facebook.drawee.a.a.c.dkj().be(X.dro()).vd(false).c(c0256a.byc.getController()).dla());
    }

    private String ai(long j) {
        long j2 = j / 1000;
        long j3 = j2 / 3600;
        long j4 = j2 % 3600;
        String format = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 / 60));
        String format2 = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 % 60));
        if (j3 == 0) {
            return this.mContext.getString(a.h.swanapp_video_duration, new Object[]{format, format2});
        }
        return this.mContext.getString(a.h.swanapp_video_duration_hour, new Object[]{String.format(Locale.getDefault(), "%02d", Long.valueOf(j3)), format, format2});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iQ(String str) {
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
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.mContext.getString(a.h.swanapp_album_video_format)).showToast();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aj(long j) {
        if (j < 3000) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.mContext.getString(a.h.swanapp_album_video_duration_min)).showToast();
            return true;
        } else if (j > 300000) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.mContext.getString(a.h.swanapp_album_video_duration_max)).showToast();
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0256a {
        private SimpleDraweeView byc;
        private ImageView byd;
        private TextView bye;
        private ImageView byf;
        private View byg;
        private TextView byh;
        private View rightBottomTipBg;
        private View selectView;

        public C0256a(View view) {
            this.byc = (SimpleDraweeView) view.findViewById(a.f.album_item_img);
            this.byf = (ImageView) view.findViewById(a.f.album_item_select_checkbox);
            this.bye = (TextView) view.findViewById(a.f.album_item_select_number);
            this.selectView = view.findViewById(a.f.album_item_selected_check);
            this.byg = view.findViewById(a.f.album_item_select_circle_view);
            this.byd = (ImageView) view.findViewById(a.f.album_item_unable_shadow);
            this.rightBottomTipBg = view.findViewById(a.f.album_item_tip_bg);
            this.byh = (TextView) view.findViewById(a.f.album_item_right_bottom_tip);
        }
    }
}
