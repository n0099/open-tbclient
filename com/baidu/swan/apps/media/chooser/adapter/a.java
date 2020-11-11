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
import com.baidu.live.tbadk.ubc.UbcStatConstant;
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
    private Activity bNY;
    public e dcA;
    private ArrayList<MediaModel> dcz = new ArrayList<>();
    private int mItemHeight;
    private int mItemWidth;
    private FrameLayout.LayoutParams mLayoutParams;

    public a(Activity activity) {
        this.bNY = activity;
        int displayWidth = ah.getDisplayWidth(this.bNY);
        int displayHeight = ah.getDisplayHeight(this.bNY);
        this.mItemWidth = displayWidth / 4;
        this.mItemHeight = displayHeight / 4;
        this.mLayoutParams = new FrameLayout.LayoutParams((displayWidth - ah.dip2px(this.bNY, 10.0f)) / 4, (displayWidth - ah.dip2px(this.bNY, 10.0f)) / 4);
    }

    public void a(e eVar) {
        this.dcA = eVar;
    }

    public void setData(ArrayList<MediaModel> arrayList) {
        if (this.dcz.size() > 0) {
            this.dcz.clear();
        }
        this.dcz.addAll(arrayList);
        d.t(this.dcz);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return d.mIsShowCamera ? this.dcz.size() + 1 : this.dcz.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (d.mIsShowCamera) {
            if (i == 0) {
                return null;
            }
            return this.dcz.get(i - 1);
        }
        return this.dcz.get(i);
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
        C0453a c0453a;
        if (getItemViewType(i) == 0) {
            View inflate = LayoutInflater.from(this.bNY).inflate(a.g.swanapp_album_camera_item, (ViewGroup) null, false);
            ax(inflate);
            return inflate;
        }
        if (view == null) {
            view = LayoutInflater.from(this.bNY).inflate(a.g.swanapp_album_select_item, (ViewGroup) null);
            C0453a c0453a2 = new C0453a(view);
            view.setTag(c0453a2);
            c0453a = c0453a2;
        } else {
            c0453a = (C0453a) view.getTag();
        }
        a(c0453a, view);
        MediaModel mediaModel = (MediaModel) getItem(i);
        if (mediaModel != null) {
            a(mediaModel.getPath(), c0453a);
            a(mediaModel, c0453a, i);
            b(mediaModel, c0453a, i);
            return view;
        }
        return view;
    }

    private void ax(View view) {
        view.findViewById(a.f.album_camera_enter).setLayoutParams(this.mLayoutParams);
        view.setTag(null);
        view.setClickable(true);
        ImageView imageView = (ImageView) view.findViewById(a.f.album_camera_icon);
        if (TextUtils.equals(d.cWY, "Image")) {
            imageView.setImageResource(a.e.swanapp_album_camera_item_selector);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.aAN();
                }
            });
            return;
        }
        imageView.setImageResource(a.e.swanapp_album_camera_video_selector);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aAP();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAN() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.ddr) {
            d.qc(d.mMode);
        } else {
            cn(this.bNY);
        }
    }

    private void cn(Context context) {
        com.baidu.swan.apps.ab.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.3
            @Override // com.baidu.swan.apps.ab.b
            public void kt(String str) {
                a.this.aAO();
            }

            @Override // com.baidu.swan.apps.ab.b
            public void af(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAO() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.bNY, d.dds, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.4
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void E(File file) {
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                com.baidu.swan.apps.media.chooser.b.e.e(imageModel);
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.dbG);
                bundle.putString("swanAppId", d.dds);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.aAV());
                bundle.putString("swanTmpPath", d.ddv);
                d.c(a.this.bNY, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void pY(String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAP() {
        if (com.baidu.swan.apps.media.chooser.b.e.getSelectedCount() >= d.ddr) {
            d.qc(d.mMode);
        } else if (af.getAvailableExternalMemorySize() < Config.RAVEN_LOG_LIMIT) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.bNY.getResources().getString(a.h.swanapp_album_camera_no_storage)).showToast();
        } else {
            co(this.bNY);
        }
    }

    private void co(Context context) {
        com.baidu.swan.apps.ab.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.5
            @Override // com.baidu.swan.apps.ab.b
            public void kt(String str) {
                a.this.aAQ();
            }

            @Override // com.baidu.swan.apps.ab.b
            public void af(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAQ() {
        com.baidu.swan.apps.media.chooser.b.b.a(this.bNY, d.dds, d.ddt, d.mIsFrontCamera, new com.baidu.swan.apps.media.chooser.c.b() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.6
            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void E(File file) {
                com.baidu.swan.apps.media.chooser.b.e.e(com.baidu.swan.apps.media.chooser.b.b.F(file));
                Bundle bundle = new Bundle();
                bundle.putBoolean("compressed", d.dbG);
                bundle.putString("swanAppId", d.dds);
                bundle.putParcelableArrayList("mediaModels", com.baidu.swan.apps.media.chooser.b.e.aAV());
                bundle.putString("swanTmpPath", d.ddv);
                d.c(a.this.bNY, bundle);
            }

            @Override // com.baidu.swan.apps.media.chooser.c.b
            public void pY(String str) {
            }
        });
    }

    private void a(final MediaModel mediaModel, final C0453a c0453a, final int i) {
        if (com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            c0453a.dcI.setImageResource(a.e.swanapp_album_select_icon_bg);
            c0453a.dcH.setVisibility(0);
            c0453a.dcH.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
        }
        if (d.a(d.mMode, mediaModel)) {
            c0453a.dcG.setVisibility(0);
        } else {
            c0453a.dcG.setVisibility(8);
        }
        if (com.baidu.swan.apps.media.chooser.b.c.ddp) {
            if (!d.isGif(mediaModel.getPath())) {
                if (d.isLargeImage(mediaModel.getPath())) {
                    c0453a.dcL.setText(this.bNY.getString(a.h.swanapp_album_large_photo));
                } else {
                    c0453a.dcM.setVisibility(8);
                }
            } else {
                c0453a.dcL.setText(this.bNY.getString(a.h.swanapp_album_gif_photo));
            }
        } else {
            c0453a.dcM.setVisibility(8);
        }
        c0453a.dcK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, c0453a);
            }
        });
        c0453a.dcF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(mediaModel, i);
            }
        });
    }

    private void b(final MediaModel mediaModel, C0453a c0453a, final int i) {
        if (mediaModel instanceof VideoModel) {
            final VideoModel videoModel = (VideoModel) mediaModel;
            c0453a.dcM.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0453a.dcM.getLayoutParams();
            if ((videoModel.getDuration() / 3600) / 1000 > 0) {
                layoutParams.width = this.bNY.getResources().getDimensionPixelSize(a.d.swanapp_album_item_longtime_width);
            } else {
                layoutParams.width = this.bNY.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_width);
            }
            layoutParams.height = this.bNY.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
            c0453a.dcM.setLayoutParams(layoutParams);
            c0453a.dcL.setText(bN(videoModel.getDuration()));
            c0453a.dcF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.media.chooser.adapter.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.pZ(videoModel.getPath()) && !a.this.bO(videoModel.getDuration())) {
                        a.this.a(mediaModel, i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaModel mediaModel, C0453a c0453a) {
        int selectedCount = com.baidu.swan.apps.media.chooser.b.e.getSelectedCount();
        if (!com.baidu.swan.apps.media.chooser.b.e.g(mediaModel)) {
            if (selectedCount >= d.ddr) {
                d.qc(d.mMode);
                return;
            } else if (selectedCount > 0 && TextUtils.equals(d.mMode, "single") && !TextUtils.equals(com.baidu.swan.apps.media.chooser.b.e.aAW(), mediaModel.getType())) {
                com.baidu.swan.apps.res.widget.b.d.k(this.bNY, a.h.swanapp_album_select_single).showToast();
                return;
            } else {
                c0453a.dcI.setImageResource(a.e.swanapp_album_select_icon_bg);
                c0453a.dcH.setVisibility(0);
                c0453a.dcH.setText(String.valueOf(com.baidu.swan.apps.media.chooser.b.e.d(mediaModel) + 1));
                com.baidu.swan.apps.media.chooser.b.e.e(mediaModel);
                c0453a.dcJ.startAnimation(AnimationUtils.loadAnimation(this.bNY, a.C0369a.swanapp_album_checkshake));
                if (this.dcA != null) {
                    this.dcA.jk(selectedCount);
                }
                notifyDataSetChanged();
                return;
            }
        }
        com.baidu.swan.apps.media.chooser.b.e.f(mediaModel);
        c0453a.dcI.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0453a.dcH.setVisibility(8);
        if (this.dcA != null) {
            this.dcA.jk(selectedCount);
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
            bundle.putBoolean("compressed", d.dbG);
            bundle.putString("swanAppId", d.dds);
            bundle.putString(UbcStatConstant.KEY_CONTENT_EXT_MODE, d.mMode);
            bundle.putString("previewFrom", "clickItem");
            bundle.putInt("previewPosition", i);
            d.b(this.bNY, bundle);
        }
    }

    private void a(C0453a c0453a, View view) {
        Resources resources = this.bNY.getResources();
        view.setBackgroundColor(resources.getColor(a.c.aiapps_white));
        c0453a.dcF.setBackgroundColor(resources.getColor(a.c.swanapp_album_item_select_bg));
        c0453a.dcH.setTextColor(resources.getColor(a.c.swanapp_album_select_number_color));
        c0453a.dcM.setBackground(resources.getDrawable(a.e.swanapp_album_item_duration_bg));
        c0453a.dcL.setTextColor(resources.getColor(a.c.aiapps_white));
        c0453a.dcG.setBackgroundColor(resources.getColor(a.c.swanapp_album_unenable_shadow_color));
        c0453a.dcF.setLayoutParams(this.mLayoutParams);
        c0453a.dcG.setLayoutParams(this.mLayoutParams);
        c0453a.dcG.setVisibility(8);
        c0453a.dcH.setVisibility(8);
        c0453a.dcK.setVisibility(8);
        c0453a.dcM.setVisibility(8);
        c0453a.dcK.setVisibility(0);
        c0453a.dcI.setImageResource(a.e.swanapp_album_unselect_thumb_icon);
        c0453a.dcM.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c0453a.dcM.getLayoutParams();
        layoutParams.width = this.bNY.getResources().getDimensionPixelSize(a.d.swanapp_album_item_tip_width);
        layoutParams.height = this.bNY.getResources().getDimensionPixelSize(a.d.swanapp_album_item_time_height);
        c0453a.dcM.setLayoutParams(layoutParams);
    }

    private void a(String str, C0453a c0453a) {
        ImageRequestBuilder ad = ImageRequestBuilder.ad(Uri.fromFile(new File(str)));
        ad.c(new com.facebook.imagepipeline.common.d((int) (this.mItemWidth / 2.0f), (int) (this.mItemHeight / 2.0f)));
        ad.At(true);
        ad.a(com.facebook.imagepipeline.common.b.enM().Al(true).enU());
        c0453a.dcF.setController(com.facebook.drawee.a.a.c.ekS().bn(ad.erY()).Af(false).c(c0453a.dcF.getController()).elJ());
    }

    private String bN(long j) {
        long j2 = j / 1000;
        long j3 = j2 / 3600;
        long j4 = j2 % 3600;
        String format = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 / 60));
        String format2 = String.format(Locale.getDefault(), "%02d", Long.valueOf(j4 % 60));
        if (j3 == 0) {
            return this.bNY.getString(a.h.swanapp_video_duration, new Object[]{format, format2});
        }
        return this.bNY.getString(a.h.swanapp_video_duration_hour, new Object[]{String.format(Locale.getDefault(), "%02d", Long.valueOf(j3)), format, format2});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pZ(String str) {
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
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.bNY.getString(a.h.swanapp_album_video_format)).showToast();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bO(long j) {
        if (j < IMConnection.RETRY_DELAY_TIMES) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.bNY.getString(a.h.swanapp_album_video_duration_min)).showToast();
            return true;
        } else if (j > 300000) {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), this.bNY.getString(a.h.swanapp_album_video_duration_max)).showToast();
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.media.chooser.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0453a {
        private SimpleDraweeView dcF;
        private ImageView dcG;
        private TextView dcH;
        private ImageView dcI;
        private View dcJ;
        private View dcK;
        private TextView dcL;
        private View dcM;

        public C0453a(View view) {
            this.dcF = (SimpleDraweeView) view.findViewById(a.f.album_item_img);
            this.dcI = (ImageView) view.findViewById(a.f.album_item_select_checkbox);
            this.dcH = (TextView) view.findViewById(a.f.album_item_select_number);
            this.dcK = view.findViewById(a.f.album_item_selected_check);
            this.dcJ = view.findViewById(a.f.album_item_select_circle_view);
            this.dcG = (ImageView) view.findViewById(a.f.album_item_unable_shadow);
            this.dcM = view.findViewById(a.f.album_item_tip_bg);
            this.dcL = (TextView) view.findViewById(a.f.album_item_right_bottom_tip);
        }
    }
}
