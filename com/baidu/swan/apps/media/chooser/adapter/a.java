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
    private ArrayList<MediaModel> dmI = new ArrayList<>();
    public e dmJ;
    private int dmK;
    private Activity mContext;
    private int mItemWidth;
    private FrameLayout.LayoutParams mLayoutParams;

    public a(Activity activity) {
        this.mContext = activity;
        int displayWidth = ah.getDisplayWidth(this.mContext);
        int displayHeight = ah.getDisplayHeight(this.mContext);
        this.mItemWidth = displayWidth / 4;
        this.dmK = displayHeight / 4;
        this.mLayoutParams = new FrameLayout.LayoutParams((displayWidth - ah.dip2px(this.mContext, 10.0f)) / 4, (displayWidth - ah.dip2px(this.mContext, 10.0f)) / 4);
    }

    public void a(e eVar) {
        this.dmJ = eVar;
    }

    public void setData(ArrayList<MediaModel> arrayList) {
        if (this.dmI.size() > 0) {
            this.dmI.clear();
        }
        this.dmI.addAll(arrayList);
        d.t(this.dmI);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return d.dnI ? this.dmI.size() + 1 : this.dmI.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (d.dnI) {
            if (i == 0) {
                return null;
            }
            return this.dmI.get(i - 1);
        }
        return this.dmI.get(i);
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
        return (d.dnI && i == 0) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0455a c0455a;
        if (getItemViewType(i) == 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(a.g.swanapp_album_camera_item, (ViewGroup) null, false);
            aF(inflate);
            return inflate;
        }
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.swanapp_album_select_item, (ViewGroup) null);
            C0455a c0455a2 = new C0455a(view);
            view.setTag(c0455a2);
            c0455a = c0455a2;
        } else {
            c0455a = (C0455a) view.getTag();
        }
        a(c0455a, view);
        MediaModel mediaModel = (MediaModel) getItem(i);
        if (mediaModel != null) {
            a(mediaModel.getPath(), c0455a);
            a(mediaModel, c0455a, i);
            b(mediaModel, c0455a, i);
            return view;
        }
        return view;
    }

    private void aF(View view) {
        view.findViewById(a.f.album_camera_enter).setLayoutParams(this.mLayoutParams);
        view.setTag(null);
        view.setClickable(true);
        ImageView imageView = (ImageView) view.findViewById(a.f.album_camera_icon);
        if (TextUtils.equals(d.dhe, "Image")) {
            imageView.setImageResource(a.e.swanapp_album_camera_item_selector);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.aEH();
                }
            });
            return;
        }
        imageView.setImageResource(a.e.swanapp_album_camera_video_selector);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aEJ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEH() {
        if (com.baidu.swan.apps.media.chooser.b.e.aEQ() >= d.dnF) {
            d.qw(d.mMode);
        } else {
            db(this.mContext);
        }
    }

    private void db(Context context) {
        com.baidu.swan.apps.ab.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.3
            @Override // com.baidu.swan.apps.ab.b
            public void kN(String str) {
                a.this.aEI();
            }

            @Override // com.baidu.swan.apps.ab.b
            public void ah(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEI() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.mContext, d.dnG, new com.baidu.swan.apps.media.chooser.listener.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.4
            @Override // com.baidu.swan.apps.media.chooser.listener.b
            public void G(File file) {
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                com.baidu.swan.apps.media.chooser.b.e.e(imageModel);
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.dlQ);
                bundle.putString("swanAppId", d.dnG);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.aEP());
                bundle.putString("swanTmpPath", d.dnJ);
                d.c(a.this.mContext, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.listener.b
            public void qs(String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEJ() {
        if (com.baidu.swan.apps.media.chooser.b.e.aEQ() >= d.dnF) {
            d.qw(d.mMode);
        } else if (af.getAvailableExternalMemorySize() < Config.RAVEN_LOG_LIMIT) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.mContext.getResources().getString(a.h.swanapp_album_camera_no_storage)).aLT();
        } else {
            dc(this.mContext);
        }
    }

    private void dc(Context context) {
        com.baidu.swan.apps.ab.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.5
            @Override // com.baidu.swan.apps.ab.b
            public void kN(String str) {
                a.this.aEK();
            }

            @Override // com.baidu.swan.apps.ab.b
            public void ah(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEK() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.mContext, d.dnG, d.dnH, d.mIsFrontCamera, new com.baidu.swan.apps.media.chooser.listener.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.6
            @Override // com.baidu.swan.apps.media.chooser.listener.b
            public void G(File file) {
                com.baidu.swan.apps.media.chooser.b.e.e(com.baidu.swan.apps.media.chooser.b.b.H(file));
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.dlQ);
                bundle.putString("swanAppId", d.dnG);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.aEP());
                bundle.putString("swanTmpPath", d.dnJ);
                d.c(a.this.mContext, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.listener.b
            public void qs(String str) {
            }
        });
    }

    private void a(final MediaModel mediaModel, final C0455a c0455a, final int i) {
        if (com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            c0455a.dmS.setImageResource(a.e.swanapp_album_select_icon_bg);
            c0455a.dmR.setVisibility(0);
            c0455a.dmR.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
        }
        if (d.a(d.mMode, mediaModel)) {
            c0455a.dmQ.setVisibility(0);
        } else {
            c0455a.dmQ.setVisibility(8);
        }
        if (c.dnD) {
            if (!d.isGif(mediaModel.getPath())) {
                if (d.qx(mediaModel.getPath())) {
                    c0455a.dmV.setText(this.mContext.getString(a.h.swanapp_album_large_photo));
                } else {
                    c0455a.dmW.setVisibility(8);
                }
            } else {
                c0455a.dmV.setText(this.mContext.getString(a.h.swanapp_album_gif_photo));
            }
        } else {
            c0455a.dmW.setVisibility(8);
        }
        c0455a.dmU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, c0455a);
            }
        });
        c0455a.dmP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, i);
            }
        });
    }

    private void b(final MediaModel mediaModel, C0455a c0455a, final int i) {
        if (mediaModel instanceof VideoModel) {
            final VideoModel videoModel = (VideoModel) mediaModel;
            c0455a.dmW.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0455a.dmW.getLayoutParams();
            if ((videoModel.getDuration() / 3600) / 1000 > 0) {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
            c0455a.dmW.setLayoutParams(layoutParams);
            c0455a.dmV.setText(cn(videoModel.getDuration()));
            c0455a.dmP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.qt(videoModel.getPath()) && !a.this.co(videoModel.getDuration())) {
                        a.this.a(mediaModel, i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaModel mediaModel, C0455a c0455a) {
        int aEQ = com.baidu.swan.apps.media.chooser.b.e.aEQ();
        if (!com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            if (aEQ >= d.dnF) {
                d.qw(d.mMode);
                return;
            } else if (aEQ > 0 && TextUtils.equals(d.mMode, "single") && !TextUtils.equals(com.baidu.swan.apps.media.chooser.b.e.aER(), mediaModel.getType())) {
                com.baidu.swan.apps.res.widget.b.d.u(this.mContext, a.h.swanapp_album_select_single).aLT();
                return;
            } else {
                c0455a.dmS.setImageResource(a.e.swanapp_album_select_icon_bg);
                c0455a.dmR.setVisibility(0);
                c0455a.dmR.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
                com.baidu.swan.apps.media.chooser.b.e.e(mediaModel);
                c0455a.dmT.startAnimation(AnimationUtils.loadAnimation(this.mContext, a.C0372a.swanapp_album_checkshake));
                if (this.dmJ != null) {
                    this.dmJ.jz(aEQ);
                }
                notifyDataSetChanged();
                return;
            }
        }
        com.baidu.swan.apps.media.chooser.b.e.f(mediaModel);
        c0455a.dmS.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0455a.dmR.setVisibility(8);
        if (this.dmJ != null) {
            this.dmJ.jz(aEQ);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaModel mediaModel, int i) {
        if (!d.a(d.mMode, mediaModel)) {
            if (d.dnI) {
                i--;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("compressed", d.dlQ);
            bundle.putString("swanAppId", d.dnG);
            bundle.putString(UbcStatConstant.KEY_CONTENT_EXT_MODE, d.mMode);
            bundle.putString("previewFrom", "clickItem");
            bundle.putInt("previewPosition", i);
            d.b(this.mContext, bundle);
        }
    }

    private void a(C0455a c0455a, View view) {
        Resources resources = this.mContext.getResources();
        view.setBackgroundColor(resources.getColor(a.c.aiapps_white));
        c0455a.dmP.setBackgroundColor(resources.getColor(a.c.swanapp_album_item_select_bg));
        c0455a.dmR.setTextColor(resources.getColor(a.c.swanapp_album_select_number_color));
        c0455a.dmW.setBackground(resources.getDrawable(a.e.swanapp_album_item_duration_bg));
        c0455a.dmV.setTextColor(resources.getColor(a.c.aiapps_white));
        c0455a.dmQ.setBackgroundColor(resources.getColor(a.c.swanapp_album_unenable_shadow_color));
        c0455a.dmP.setLayoutParams(this.mLayoutParams);
        c0455a.dmQ.setLayoutParams(this.mLayoutParams);
        c0455a.dmQ.setVisibility(8);
        c0455a.dmR.setVisibility(8);
        c0455a.dmU.setVisibility(8);
        c0455a.dmW.setVisibility(8);
        c0455a.dmU.setVisibility(0);
        c0455a.dmS.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0455a.dmW.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0455a.dmW.getLayoutParams();
        layoutParams.width = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_tip_width);
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
        c0455a.dmW.setLayoutParams(layoutParams);
    }

    private void a(String str, C0455a c0455a) {
        ImageRequestBuilder aj = ImageRequestBuilder.aj(Uri.fromFile(new File(str)));
        aj.c(new com.facebook.imagepipeline.common.d((int) (this.mItemWidth / 2.0f), (int) (this.dmK / 2.0f)));
        aj.Bj(true);
        aj.a(com.facebook.imagepipeline.common.b.exD().Bd(true).exL());
        c0455a.dmP.setController(com.facebook.drawee.a.a.c.euP().bo(aj.eBI()).AX(false).c(c0455a.dmP.getController()).evG());
    }

    private String cn(long j) {
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
    public boolean qt(String str) {
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
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.mContext.getString(a.h.swanapp_album_video_format)).aLT();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean co(long j) {
        if (j < IMConnection.RETRY_DELAY_TIMES) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.mContext.getString(a.h.swanapp_album_video_duration_min)).aLT();
            return true;
        } else if (j > 300000) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.mContext.getString(a.h.swanapp_album_video_duration_max)).aLT();
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0455a {
        private SimpleDraweeView dmP;
        private ImageView dmQ;
        private TextView dmR;
        private ImageView dmS;
        private View dmT;
        private View dmU;
        private TextView dmV;
        private View dmW;

        public C0455a(View view) {
            this.dmP = (SimpleDraweeView) view.findViewById(a.f.album_item_img);
            this.dmS = (ImageView) view.findViewById(a.f.album_item_select_checkbox);
            this.dmR = (TextView) view.findViewById(a.f.album_item_select_number);
            this.dmU = view.findViewById(a.f.album_item_selected_check);
            this.dmT = view.findViewById(a.f.album_item_select_circle_view);
            this.dmQ = (ImageView) view.findViewById(a.f.album_item_unable_shadow);
            this.dmW = view.findViewById(a.f.album_item_tip_bg);
            this.dmV = (TextView) view.findViewById(a.f.album_item_right_bottom_tip);
        }
    }
}
