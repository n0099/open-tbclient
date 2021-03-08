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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private ArrayList<MediaModel> dlI = new ArrayList<>();
    public e dlJ;
    private int dlK;
    private Activity mContext;
    private int mItemWidth;
    private FrameLayout.LayoutParams mLayoutParams;

    public a(Activity activity) {
        this.mContext = activity;
        int displayWidth = ah.getDisplayWidth(this.mContext);
        int displayHeight = ah.getDisplayHeight(this.mContext);
        this.mItemWidth = displayWidth / 4;
        this.dlK = displayHeight / 4;
        this.mLayoutParams = new FrameLayout.LayoutParams((displayWidth - ah.dip2px(this.mContext, 10.0f)) / 4, (displayWidth - ah.dip2px(this.mContext, 10.0f)) / 4);
    }

    public void a(e eVar) {
        this.dlJ = eVar;
    }

    public void setData(ArrayList<MediaModel> arrayList) {
        if (this.dlI.size() > 0) {
            this.dlI.clear();
        }
        this.dlI.addAll(arrayList);
        d.o(this.dlI);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return d.dmH ? this.dlI.size() + 1 : this.dlI.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (d.dmH) {
            if (i == 0) {
                return null;
            }
            return this.dlI.get(i - 1);
        }
        return this.dlI.get(i);
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
        return (d.dmH && i == 0) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0441a c0441a;
        if (getItemViewType(i) == 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(a.g.swanapp_album_camera_item, (ViewGroup) null, false);
            aB(inflate);
            return inflate;
        }
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.swanapp_album_select_item, (ViewGroup) null);
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

    private void aB(View view) {
        view.findViewById(a.f.album_camera_enter).setLayoutParams(this.mLayoutParams);
        view.setTag(null);
        view.setClickable(true);
        ImageView imageView = (ImageView) view.findViewById(a.f.album_camera_icon);
        if (TextUtils.equals(d.dge, "Image")) {
            imageView.setImageResource(a.e.swanapp_album_camera_item_selector);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.aBo();
                }
            });
            return;
        }
        imageView.setImageResource(a.e.swanapp_album_camera_video_selector);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aBq();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBo() {
        if (com.baidu.swan.apps.media.chooser.b.e.aBx() >= d.dmE) {
            d.pK(d.mMode);
        } else {
            cY(this.mContext);
        }
    }

    private void cY(Context context) {
        com.baidu.swan.apps.ab.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.3
            @Override // com.baidu.swan.apps.ab.b
            public void kb(String str) {
                a.this.aBp();
            }

            @Override // com.baidu.swan.apps.ab.b
            public void am(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBp() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.mContext, d.dmF, new com.baidu.swan.apps.media.chooser.listener.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.4
            @Override // com.baidu.swan.apps.media.chooser.listener.b
            public void B(File file) {
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                com.baidu.swan.apps.media.chooser.b.e.e(imageModel);
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.dkQ);
                bundle.putString("swanAppId", d.dmF);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.aBw());
                bundle.putString("swanTmpPath", d.dmI);
                d.c(a.this.mContext, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.listener.b
            public void pG(String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBq() {
        if (com.baidu.swan.apps.media.chooser.b.e.aBx() >= d.dmE) {
            d.pK(d.mMode);
        } else if (af.getAvailableExternalMemorySize() < Config.RAVEN_LOG_LIMIT) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.mContext.getResources().getString(a.h.swanapp_album_camera_no_storage)).aIv();
        } else {
            cZ(this.mContext);
        }
    }

    private void cZ(Context context) {
        com.baidu.swan.apps.ab.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.5
            @Override // com.baidu.swan.apps.ab.b
            public void kb(String str) {
                a.this.aBr();
            }

            @Override // com.baidu.swan.apps.ab.b
            public void am(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBr() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.mContext, d.dmF, d.dmG, d.mIsFrontCamera, new com.baidu.swan.apps.media.chooser.listener.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.6
            @Override // com.baidu.swan.apps.media.chooser.listener.b
            public void B(File file) {
                com.baidu.swan.apps.media.chooser.b.e.e(com.baidu.swan.apps.media.chooser.b.b.C(file));
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.dkQ);
                bundle.putString("swanAppId", d.dmF);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.aBw());
                bundle.putString("swanTmpPath", d.dmI);
                d.c(a.this.mContext, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.listener.b
            public void pG(String str) {
            }
        });
    }

    private void a(final MediaModel mediaModel, final C0441a c0441a, final int i) {
        if (com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            c0441a.dlS.setImageResource(a.e.swanapp_album_select_icon_bg);
            c0441a.dlR.setVisibility(0);
            c0441a.dlR.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
        }
        if (d.a(d.mMode, mediaModel)) {
            c0441a.dlQ.setVisibility(0);
        } else {
            c0441a.dlQ.setVisibility(8);
        }
        if (c.dmC) {
            if (!d.isGif(mediaModel.getPath())) {
                if (d.pL(mediaModel.getPath())) {
                    c0441a.dlV.setText(this.mContext.getString(a.h.swanapp_album_large_photo));
                } else {
                    c0441a.dlW.setVisibility(8);
                }
            } else {
                c0441a.dlV.setText(this.mContext.getString(a.h.swanapp_album_gif_photo));
            }
        } else {
            c0441a.dlW.setVisibility(8);
        }
        c0441a.dlU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, c0441a);
            }
        });
        c0441a.dlP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, i);
            }
        });
    }

    private void b(final MediaModel mediaModel, C0441a c0441a, final int i) {
        if (mediaModel instanceof VideoModel) {
            final VideoModel videoModel = (VideoModel) mediaModel;
            c0441a.dlW.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0441a.dlW.getLayoutParams();
            if ((videoModel.getDuration() / 3600) / 1000 > 0) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
            c0441a.dlW.setLayoutParams(layoutParams);
            c0441a.dlV.setText(ct(videoModel.getDuration()));
            c0441a.dlP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.pH(videoModel.getPath()) && !a.this.cu(videoModel.getDuration())) {
                        a.this.a(mediaModel, i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaModel mediaModel, C0441a c0441a) {
        int aBx = com.baidu.swan.apps.media.chooser.b.e.aBx();
        if (!com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            if (aBx >= d.dmE) {
                d.pK(d.mMode);
                return;
            } else if (aBx > 0 && TextUtils.equals(d.mMode, "single") && !TextUtils.equals(com.baidu.swan.apps.media.chooser.b.e.aBy(), mediaModel.getType())) {
                com.baidu.swan.apps.res.widget.b.d.u(this.mContext, a.h.swanapp_album_select_single).aIv();
                return;
            } else {
                c0441a.dlS.setImageResource(a.e.swanapp_album_select_icon_bg);
                c0441a.dlR.setVisibility(0);
                c0441a.dlR.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
                com.baidu.swan.apps.media.chooser.b.e.e(mediaModel);
                c0441a.dlT.startAnimation(AnimationUtils.loadAnimation(this.mContext, a.C0358a.swanapp_album_checkshake));
                if (this.dlJ != null) {
                    this.dlJ.hX(aBx);
                }
                notifyDataSetChanged();
                return;
            }
        }
        com.baidu.swan.apps.media.chooser.b.e.f(mediaModel);
        c0441a.dlS.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0441a.dlR.setVisibility(8);
        if (this.dlJ != null) {
            this.dlJ.hX(aBx);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaModel mediaModel, int i) {
        if (!d.a(d.mMode, mediaModel)) {
            if (d.dmH) {
                i--;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.dkQ);
            bundle.putString("swanAppId", d.dmF);
            bundle.putString(UbcStatConstant.KEY_CONTENT_EXT_MODE, d.mMode);
            bundle.putString("previewFrom", "clickItem");
            bundle.putInt("previewPosition", i);
            d.b(this.mContext, bundle);
        }
    }

    private void a(C0441a c0441a, View view) {
        Resources resources = this.mContext.getResources();
        view.setBackgroundColor(resources.getColor(a.c.aiapps_white));
        c0441a.dlP.setBackgroundColor(resources.getColor(a.c.swanapp_album_item_select_bg));
        c0441a.dlR.setTextColor(resources.getColor(a.c.swanapp_album_select_number_color));
        c0441a.dlW.setBackground(resources.getDrawable(a.e.swanapp_album_item_duration_bg));
        c0441a.dlV.setTextColor(resources.getColor(a.c.aiapps_white));
        c0441a.dlQ.setBackgroundColor(resources.getColor(a.c.swanapp_album_unenable_shadow_color));
        c0441a.dlP.setLayoutParams(this.mLayoutParams);
        c0441a.dlQ.setLayoutParams(this.mLayoutParams);
        c0441a.dlQ.setVisibility(8);
        c0441a.dlR.setVisibility(8);
        c0441a.dlU.setVisibility(8);
        c0441a.dlW.setVisibility(8);
        c0441a.dlU.setVisibility(0);
        c0441a.dlS.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0441a.dlW.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0441a.dlW.getLayoutParams();
        layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_tip_width);
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
        c0441a.dlW.setLayoutParams(layoutParams);
    }

    private void a(String str, C0441a c0441a) {
        ImageRequestBuilder ag = ImageRequestBuilder.ag(Uri.fromFile(new File(str)));
        ag.c(new com.facebook.imagepipeline.common.d((int) (this.mItemWidth / 2.0f), (int) (this.dlK / 2.0f)));
        ag.Bw(true);
        ag.a(com.facebook.imagepipeline.common.b.ewu().Bq(true).ewC());
        c0441a.dlP.setController(com.facebook.drawee.a.a.c.etF().bq(ag.eAz()).Bk(false).c(c0441a.dlP.getController()).euw());
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
    public boolean pH(String str) {
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
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.mContext.getString(a.h.swanapp_album_video_format)).aIv();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cu(long j) {
        if (j < IMConnection.RETRY_DELAY_TIMES) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.mContext.getString(a.h.swanapp_album_video_duration_min)).aIv();
            return true;
        } else if (j > 300000) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.mContext.getString(a.h.swanapp_album_video_duration_max)).aIv();
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0441a {
        private SimpleDraweeView dlP;
        private ImageView dlQ;
        private TextView dlR;
        private ImageView dlS;
        private View dlT;
        private View dlU;
        private TextView dlV;
        private View dlW;

        public C0441a(View view) {
            this.dlP = (SimpleDraweeView) view.findViewById(a.f.album_item_img);
            this.dlS = (ImageView) view.findViewById(a.f.album_item_select_checkbox);
            this.dlR = (TextView) view.findViewById(a.f.album_item_select_number);
            this.dlU = view.findViewById(a.f.album_item_selected_check);
            this.dlT = view.findViewById(a.f.album_item_select_circle_view);
            this.dlQ = (ImageView) view.findViewById(a.f.album_item_unable_shadow);
            this.dlW = view.findViewById(a.f.album_item_tip_bg);
            this.dlV = (TextView) view.findViewById(a.f.album_item_right_bottom_tip);
        }
    }
}
