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
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.af;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.media.chooser.b.c;
import com.baidu.swan.apps.media.chooser.b.d;
import com.baidu.swan.apps.media.chooser.listener.e;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.webkit.sdk.PermissionRequest;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    private ArrayList<MediaModel> dkh = new ArrayList<>();
    public e dki;
    private int dkj;
    private Activity mContext;
    private int mItemWidth;
    private FrameLayout.LayoutParams mLayoutParams;

    public a(Activity activity) {
        this.mContext = activity;
        int displayWidth = ah.getDisplayWidth(this.mContext);
        int displayHeight = ah.getDisplayHeight(this.mContext);
        this.mItemWidth = displayWidth / 4;
        this.dkj = displayHeight / 4;
        this.mLayoutParams = new FrameLayout.LayoutParams((displayWidth - ah.dip2px(this.mContext, 10.0f)) / 4, (displayWidth - ah.dip2px(this.mContext, 10.0f)) / 4);
    }

    public void a(e eVar) {
        this.dki = eVar;
    }

    public void setData(ArrayList<MediaModel> arrayList) {
        if (this.dkh.size() > 0) {
            this.dkh.clear();
        }
        this.dkh.addAll(arrayList);
        d.o(this.dkh);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return d.dlg ? this.dkh.size() + 1 : this.dkh.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (d.dlg) {
            if (i == 0) {
                return null;
            }
            return this.dkh.get(i - 1);
        }
        return this.dkh.get(i);
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
        return (d.dlg && i == 0) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0435a c0435a;
        if (getItemViewType(i) == 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(a.g.swanapp_album_camera_item, (ViewGroup) null, false);
            aB(inflate);
            return inflate;
        }
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.swanapp_album_select_item, (ViewGroup) null);
            C0435a c0435a2 = new C0435a(view);
            view.setTag(c0435a2);
            c0435a = c0435a2;
        } else {
            c0435a = (C0435a) view.getTag();
        }
        a(c0435a, view);
        MediaModel mediaModel = (MediaModel) getItem(i);
        if (mediaModel != null) {
            a(mediaModel.getPath(), c0435a);
            a(mediaModel, c0435a, i);
            b(mediaModel, c0435a, i);
            return view;
        }
        return view;
    }

    private void aB(View view) {
        view.findViewById(a.f.album_camera_enter).setLayoutParams(this.mLayoutParams);
        view.setTag(null);
        view.setClickable(true);
        ImageView imageView = (ImageView) view.findViewById(a.f.album_camera_icon);
        if (TextUtils.equals(d.deD, "Image")) {
            imageView.setImageResource(a.e.swanapp_album_camera_item_selector);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.aBl();
                }
            });
            return;
        }
        imageView.setImageResource(a.e.swanapp_album_camera_video_selector);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aBn();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBl() {
        if (com.baidu.swan.apps.media.chooser.b.e.aBu() >= d.dld) {
            d.pD(d.mMode);
        } else {
            cZ(this.mContext);
        }
    }

    private void cZ(Context context) {
        com.baidu.swan.apps.ab.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.3
            @Override // com.baidu.swan.apps.ab.b
            public void jU(String str) {
                a.this.aBm();
            }

            @Override // com.baidu.swan.apps.ab.b
            public void am(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBm() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.mContext, d.dle, new com.baidu.swan.apps.media.chooser.listener.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.4
            @Override // com.baidu.swan.apps.media.chooser.listener.b
            public void B(File file) {
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                com.baidu.swan.apps.media.chooser.b.e.e(imageModel);
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.djp);
                bundle.putString("swanAppId", d.dle);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.aBt());
                bundle.putString("swanTmpPath", d.dlh);
                d.c(a.this.mContext, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.listener.b
            public void pz(String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBn() {
        if (com.baidu.swan.apps.media.chooser.b.e.aBu() >= d.dld) {
            d.pD(d.mMode);
        } else if (af.getAvailableExternalMemorySize() < Config.RAVEN_LOG_LIMIT) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.mContext.getResources().getString(a.h.swanapp_album_camera_no_storage)).aIs();
        } else {
            da(this.mContext);
        }
    }

    private void da(Context context) {
        com.baidu.swan.apps.ab.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.5
            @Override // com.baidu.swan.apps.ab.b
            public void jU(String str) {
                a.this.aBo();
            }

            @Override // com.baidu.swan.apps.ab.b
            public void am(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBo() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.mContext, d.dle, d.dlf, d.mIsFrontCamera, new com.baidu.swan.apps.media.chooser.listener.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.6
            @Override // com.baidu.swan.apps.media.chooser.listener.b
            public void B(File file) {
                com.baidu.swan.apps.media.chooser.b.e.e(com.baidu.swan.apps.media.chooser.b.b.C(file));
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.djp);
                bundle.putString("swanAppId", d.dle);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.aBt());
                bundle.putString("swanTmpPath", d.dlh);
                d.c(a.this.mContext, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.listener.b
            public void pz(String str) {
            }
        });
    }

    private void a(final MediaModel mediaModel, final C0435a c0435a, final int i) {
        if (com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            c0435a.dkr.setImageResource(a.e.swanapp_album_select_icon_bg);
            c0435a.dkq.setVisibility(0);
            c0435a.dkq.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
        }
        if (d.a(d.mMode, mediaModel)) {
            c0435a.dkp.setVisibility(0);
        } else {
            c0435a.dkp.setVisibility(8);
        }
        if (c.dlb) {
            if (!d.isGif(mediaModel.getPath())) {
                if (d.pE(mediaModel.getPath())) {
                    c0435a.dku.setText(this.mContext.getString(a.h.swanapp_album_large_photo));
                } else {
                    c0435a.dkv.setVisibility(8);
                }
            } else {
                c0435a.dku.setText(this.mContext.getString(a.h.swanapp_album_gif_photo));
            }
        } else {
            c0435a.dkv.setVisibility(8);
        }
        c0435a.dkt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, c0435a);
            }
        });
        c0435a.dko.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, i);
            }
        });
    }

    private void b(final MediaModel mediaModel, C0435a c0435a, final int i) {
        if (mediaModel instanceof VideoModel) {
            final VideoModel videoModel = (VideoModel) mediaModel;
            c0435a.dkv.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0435a.dkv.getLayoutParams();
            if ((videoModel.getDuration() / 3600) / 1000 > 0) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
            c0435a.dkv.setLayoutParams(layoutParams);
            c0435a.dku.setText(ct(videoModel.getDuration()));
            c0435a.dko.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.pA(videoModel.getPath()) && !a.this.cu(videoModel.getDuration())) {
                        a.this.a(mediaModel, i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaModel mediaModel, C0435a c0435a) {
        int aBu = com.baidu.swan.apps.media.chooser.b.e.aBu();
        if (!com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            if (aBu >= d.dld) {
                d.pD(d.mMode);
                return;
            } else if (aBu > 0 && TextUtils.equals(d.mMode, "single") && !TextUtils.equals(com.baidu.swan.apps.media.chooser.b.e.aBv(), mediaModel.getType())) {
                com.baidu.swan.apps.res.widget.b.d.u(this.mContext, a.h.swanapp_album_select_single).aIs();
                return;
            } else {
                c0435a.dkr.setImageResource(a.e.swanapp_album_select_icon_bg);
                c0435a.dkq.setVisibility(0);
                c0435a.dkq.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
                com.baidu.swan.apps.media.chooser.b.e.e(mediaModel);
                c0435a.dks.startAnimation(AnimationUtils.loadAnimation(this.mContext, a.C0352a.swanapp_album_checkshake));
                if (this.dki != null) {
                    this.dki.hW(aBu);
                }
                notifyDataSetChanged();
                return;
            }
        }
        com.baidu.swan.apps.media.chooser.b.e.f(mediaModel);
        c0435a.dkr.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0435a.dkq.setVisibility(8);
        if (this.dki != null) {
            this.dki.hW(aBu);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaModel mediaModel, int i) {
        if (!d.a(d.mMode, mediaModel)) {
            if (d.dlg) {
                i--;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.djp);
            bundle.putString("swanAppId", d.dle);
            bundle.putString(UbcStatConstant.KEY_CONTENT_EXT_MODE, d.mMode);
            bundle.putString("previewFrom", "clickItem");
            bundle.putInt("previewPosition", i);
            d.b(this.mContext, bundle);
        }
    }

    private void a(C0435a c0435a, View view) {
        Resources resources = this.mContext.getResources();
        view.setBackgroundColor(resources.getColor(a.c.aiapps_white));
        c0435a.dko.setBackgroundColor(resources.getColor(a.c.swanapp_album_item_select_bg));
        c0435a.dkq.setTextColor(resources.getColor(a.c.swanapp_album_select_number_color));
        c0435a.dkv.setBackground(resources.getDrawable(a.e.swanapp_album_item_duration_bg));
        c0435a.dku.setTextColor(resources.getColor(a.c.aiapps_white));
        c0435a.dkp.setBackgroundColor(resources.getColor(a.c.swanapp_album_unenable_shadow_color));
        c0435a.dko.setLayoutParams(this.mLayoutParams);
        c0435a.dkp.setLayoutParams(this.mLayoutParams);
        c0435a.dkp.setVisibility(8);
        c0435a.dkq.setVisibility(8);
        c0435a.dkt.setVisibility(8);
        c0435a.dkv.setVisibility(8);
        c0435a.dkt.setVisibility(0);
        c0435a.dkr.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0435a.dkv.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0435a.dkv.getLayoutParams();
        layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_tip_width);
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
        c0435a.dkv.setLayoutParams(layoutParams);
    }

    private void a(String str, C0435a c0435a) {
        ImageRequestBuilder ag = ImageRequestBuilder.ag(Uri.fromFile(new File(str)));
        ag.c(new com.facebook.imagepipeline.common.d((int) (this.mItemWidth / 2.0f), (int) (this.dkj / 2.0f)));
        ag.By(true);
        ag.a(com.facebook.imagepipeline.common.b.ewl().Bs(true).ewt());
        c0435a.dko.setController(com.facebook.drawee.a.a.c.etw().bo(ag.eAq()).Bm(false).c(c0435a.dko.getController()).eun());
    }

    private String ct(long j) {
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
    public boolean pA(String str) {
        String str2 = "";
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            str2 = mediaMetadataRetriever.extractMetadata(12);
        } catch (Exception e) {
            if (c.DEBUG) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str2) && str2.startsWith("video/")) {
            return TextUtils.equals("video/mp4", str2) || TextUtils.equals("video/3gp", str2) || TextUtils.equals("video/webm", str2) || TextUtils.equals("video/mkv", str2);
        }
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.mContext.getString(a.h.swanapp_album_video_format)).aIs();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cu(long j) {
        if (j < IMConnection.RETRY_DELAY_TIMES) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.mContext.getString(a.h.swanapp_album_video_duration_min)).aIs();
            return true;
        } else if (j > 300000) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.mContext.getString(a.h.swanapp_album_video_duration_max)).aIs();
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0435a {
        private SimpleDraweeView dko;
        private ImageView dkp;
        private TextView dkq;
        private ImageView dkr;
        private View dks;
        private View dkt;
        private TextView dku;
        private View dkv;

        public C0435a(View view) {
            this.dko = (SimpleDraweeView) view.findViewById(a.f.album_item_img);
            this.dkr = (ImageView) view.findViewById(a.f.album_item_select_checkbox);
            this.dkq = (TextView) view.findViewById(a.f.album_item_select_number);
            this.dkt = view.findViewById(a.f.album_item_selected_check);
            this.dks = view.findViewById(a.f.album_item_select_circle_view);
            this.dkp = (ImageView) view.findViewById(a.f.album_item_unable_shadow);
            this.dkv = view.findViewById(a.f.album_item_tip_bg);
            this.dku = (TextView) view.findViewById(a.f.album_item_right_bottom_tip);
        }
    }
}
