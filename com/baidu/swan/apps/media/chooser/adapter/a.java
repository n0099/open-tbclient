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
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private ArrayList<MediaModel> bCc = new ArrayList<>();
    public e bCd;
    private FrameLayout.LayoutParams bCe;
    private Activity mContext;
    private int mItemHeight;
    private int mItemWidth;

    public a(Activity activity) {
        this.mContext = activity;
        int displayWidth = af.getDisplayWidth(this.mContext);
        int displayHeight = af.getDisplayHeight(this.mContext);
        this.mItemWidth = displayWidth / 4;
        this.mItemHeight = displayHeight / 4;
        this.bCe = new FrameLayout.LayoutParams((displayWidth - af.dip2px(this.mContext, 10.0f)) / 4, (displayWidth - af.dip2px(this.mContext, 10.0f)) / 4);
    }

    public void a(e eVar) {
        this.bCd = eVar;
    }

    public void setData(ArrayList<MediaModel> arrayList) {
        if (this.bCc.size() > 0) {
            this.bCc.clear();
        }
        this.bCc.addAll(arrayList);
        d.o(this.bCc);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return d.mIsShowCamera ? this.bCc.size() + 1 : this.bCc.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (d.mIsShowCamera) {
            if (i == 0) {
                return null;
            }
            return this.bCc.get(i - 1);
        }
        return this.bCc.get(i);
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
        C0266a c0266a;
        if (getItemViewType(i) == 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(a.g.swanapp_album_camera_item, (ViewGroup) null, false);
            ak(inflate);
            return inflate;
        }
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.swanapp_album_select_item, (ViewGroup) null);
            C0266a c0266a2 = new C0266a(view);
            view.setTag(c0266a2);
            c0266a = c0266a2;
        } else {
            c0266a = (C0266a) view.getTag();
        }
        a(c0266a, view);
        MediaModel mediaModel = (MediaModel) getItem(i);
        if (mediaModel != null) {
            a(mediaModel.getPath(), c0266a);
            a(mediaModel, c0266a, i);
            b(mediaModel, c0266a, i);
            return view;
        }
        return view;
    }

    private void ak(View view) {
        view.findViewById(a.f.album_camera_enter).setLayoutParams(this.bCe);
        view.setTag(null);
        view.setClickable(true);
        ImageView imageView = (ImageView) view.findViewById(a.f.album_camera_icon);
        if (TextUtils.equals(d.bCp, "Image")) {
            imageView.setImageResource(a.e.swanapp_album_camera_item_selector);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.Xz();
                }
            });
            return;
        }
        imageView.setImageResource(a.e.swanapp_album_camera_video_selector);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.XB();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xz() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.mMaxSelected) {
            d.ji(d.mMode);
        } else {
            cm(this.mContext);
        }
    }

    private void cm(Context context) {
        com.baidu.swan.apps.af.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.af.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.3
            @Override // com.baidu.swan.apps.af.b
            public void fD(String str) {
                a.this.XA();
            }

            @Override // com.baidu.swan.apps.af.b
            public void v(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XA() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.mContext, d.bCS, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.4
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void s(File file) {
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                com.baidu.swan.apps.media.chooser.b.e.e(imageModel);
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.bBt);
                bundle.putString("swanAppId", d.bCS);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.XH());
                bundle.putString("swanTmpPath", d.bCU);
                d.c(a.this.mContext, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void je(String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XB() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.mMaxSelected) {
            d.ji(d.mMode);
        } else if (ac.getAvailableExternalMemorySize() < Config.RAVEN_LOG_LIMIT) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.mContext.getResources().getString(a.h.swanapp_album_camera_no_storage)).showToast();
        } else {
            cn(this.mContext);
        }
    }

    private void cn(Context context) {
        com.baidu.swan.apps.af.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.af.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.5
            @Override // com.baidu.swan.apps.af.b
            public void fD(String str) {
                a.this.XC();
            }

            @Override // com.baidu.swan.apps.af.b
            public void v(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XC() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.mContext, d.bCS, d.bCT, d.mIsFrontCamera, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.6
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void s(File file) {
                com.baidu.swan.apps.media.chooser.b.e.e(com.baidu.swan.apps.media.chooser.b.b.t(file));
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.bBt);
                bundle.putString("swanAppId", d.bCS);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.XH());
                bundle.putString("swanTmpPath", d.bCU);
                d.c(a.this.mContext, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void je(String str) {
            }
        });
    }

    private void a(final MediaModel mediaModel, final C0266a c0266a, final int i) {
        if (com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            c0266a.bCm.setImageResource(a.e.swanapp_album_select_icon_bg);
            c0266a.bCl.setVisibility(0);
            c0266a.bCl.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
        }
        if (d.a(d.mMode, mediaModel)) {
            c0266a.bCk.setVisibility(0);
        } else {
            c0266a.bCk.setVisibility(8);
        }
        if (com.baidu.swan.apps.media.chooser.b.c.bCQ) {
            if (!d.isGif(mediaModel.getPath())) {
                if (d.isLargeImage(mediaModel.getPath())) {
                    c0266a.bCo.setText(this.mContext.getString(a.h.swanapp_album_large_photo));
                } else {
                    c0266a.rightBottomTipBg.setVisibility(8);
                }
            } else {
                c0266a.bCo.setText(this.mContext.getString(a.h.swanapp_album_gif_photo));
            }
        } else {
            c0266a.rightBottomTipBg.setVisibility(8);
        }
        c0266a.selectView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, c0266a);
            }
        });
        c0266a.bCj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, i);
            }
        });
    }

    private void b(final MediaModel mediaModel, C0266a c0266a, final int i) {
        if (mediaModel instanceof VideoModel) {
            final VideoModel videoModel = (VideoModel) mediaModel;
            c0266a.rightBottomTipBg.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0266a.rightBottomTipBg.getLayoutParams();
            if ((videoModel.getDuration() / 3600) / 1000 > 0) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
            c0266a.rightBottomTipBg.setLayoutParams(layoutParams);
            c0266a.bCo.setText(am(videoModel.getDuration()));
            c0266a.bCj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.jf(videoModel.getPath()) && !a.this.an(videoModel.getDuration())) {
                        a.this.a(mediaModel, i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaModel mediaModel, C0266a c0266a) {
        int selectedCount = com.baidu.swan.apps.media.chooser.b.e.getSelectedCount();
        if (!com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            if (selectedCount >= d.mMaxSelected) {
                d.ji(d.mMode);
                return;
            } else if (selectedCount > 0 && TextUtils.equals(d.mMode, "single") && !TextUtils.equals(com.baidu.swan.apps.media.chooser.b.e.XI(), mediaModel.getType())) {
                com.baidu.swan.apps.res.widget.b.d.q(this.mContext, a.h.swanapp_album_select_single).showToast();
                return;
            } else {
                c0266a.bCm.setImageResource(a.e.swanapp_album_select_icon_bg);
                c0266a.bCl.setVisibility(0);
                c0266a.bCl.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
                com.baidu.swan.apps.media.chooser.b.e.e(mediaModel);
                c0266a.bCn.startAnimation(AnimationUtils.loadAnimation(this.mContext, a.C0197a.swanapp_album_checkshake));
                if (this.bCd != null) {
                    this.bCd.selectChanged(selectedCount);
                }
                notifyDataSetChanged();
                return;
            }
        }
        com.baidu.swan.apps.media.chooser.b.e.f(mediaModel);
        c0266a.bCm.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0266a.bCl.setVisibility(8);
        if (this.bCd != null) {
            this.bCd.selectChanged(selectedCount);
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
            bundle.putBoolean("compressed", d.bBt);
            bundle.putString("swanAppId", d.bCS);
            bundle.putString("mode", d.mMode);
            bundle.putString("previewFrom", "clickItem");
            bundle.putInt("previewPosition", i);
            d.b(this.mContext, bundle);
        }
    }

    private void a(C0266a c0266a, View view) {
        Resources resources = this.mContext.getResources();
        view.setBackgroundColor(resources.getColor(a.c.aiapps_white));
        c0266a.bCj.setBackgroundColor(resources.getColor(a.c.swanapp_album_item_select_bg));
        c0266a.bCl.setTextColor(resources.getColor(a.c.swanapp_album_select_number_color));
        c0266a.rightBottomTipBg.setBackground(resources.getDrawable(a.e.swanapp_album_item_duration_bg));
        c0266a.bCo.setTextColor(resources.getColor(a.c.aiapps_white));
        c0266a.bCk.setBackgroundColor(resources.getColor(a.c.swanapp_album_unenable_shadow_color));
        c0266a.bCj.setLayoutParams(this.bCe);
        c0266a.bCk.setLayoutParams(this.bCe);
        c0266a.bCk.setVisibility(8);
        c0266a.bCl.setVisibility(8);
        c0266a.selectView.setVisibility(8);
        c0266a.rightBottomTipBg.setVisibility(8);
        c0266a.selectView.setVisibility(0);
        c0266a.bCm.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0266a.rightBottomTipBg.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0266a.rightBottomTipBg.getLayoutParams();
        layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_tip_width);
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
        c0266a.rightBottomTipBg.setLayoutParams(layoutParams);
    }

    private void a(String str, C0266a c0266a) {
        ImageRequestBuilder Y = ImageRequestBuilder.Y(Uri.fromFile(new File(str)));
        Y.c(new com.facebook.imagepipeline.common.d((int) (this.mItemWidth / 2.0f), (int) (this.mItemHeight / 2.0f)));
        Y.vw(true);
        Y.a(com.facebook.imagepipeline.common.b.dol().vo(true).dot());
        c0266a.bCj.setController(com.facebook.drawee.a.a.c.dlw().bg(Y.dsA()).vh(false).c(c0266a.bCj.getController()).dmn());
    }

    private String am(long j) {
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
    public boolean jf(String str) {
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
    public boolean an(long j) {
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
    /* loaded from: classes11.dex */
    public class C0266a {
        private SimpleDraweeView bCj;
        private ImageView bCk;
        private TextView bCl;
        private ImageView bCm;
        private View bCn;
        private TextView bCo;
        private View rightBottomTipBg;
        private View selectView;

        public C0266a(View view) {
            this.bCj = (SimpleDraweeView) view.findViewById(a.f.album_item_img);
            this.bCm = (ImageView) view.findViewById(a.f.album_item_select_checkbox);
            this.bCl = (TextView) view.findViewById(a.f.album_item_select_number);
            this.selectView = view.findViewById(a.f.album_item_selected_check);
            this.bCn = view.findViewById(a.f.album_item_select_circle_view);
            this.bCk = (ImageView) view.findViewById(a.f.album_item_unable_shadow);
            this.rightBottomTipBg = view.findViewById(a.f.album_item_tip_bg);
            this.bCo = (TextView) view.findViewById(a.f.album_item_right_bottom_tip);
        }
    }
}
