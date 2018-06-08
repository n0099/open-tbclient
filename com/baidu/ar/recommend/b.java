package com.baidu.ar.recommend;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.ar.bean.ARResource;
import com.baidu.ar.rotate.Orientation;
import com.baidu.ar.ui.rotateview.IRotateView;
import com.baidu.ar.ui.rotateview.RotateViewGroup;
import com.baidu.ar.ui.rotateview.RotateViewUtils;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.Utils;
/* loaded from: classes3.dex */
public class b extends FrameLayout implements IRotateView {
    private ImageView a;
    private ImageView b;
    private ImageView c;
    private ISCircleLoadingView d;
    private ImageView e;
    private LoadingView f;
    private RotateViewGroup g;

    public b(Context context) {
        super(context);
        Res.inflate("bdar_layout_relative_item", this, true);
        this.g = (RotateViewGroup) findViewById(Res.id("bdar_recommend_item_rotate_group"));
        this.a = (ImageView) findViewById(Res.id("bdar_recommend_image"));
        this.b = (ImageView) findViewById(Res.id("bdar_recommend_image_selected"));
        this.d = (ISCircleLoadingView) findViewById(Res.id("bdar_recommend_download_progress"));
        this.d.setLoadingColor(2130706432);
        this.d.setCircleMaxRadius(Utils.dipToPx(context, 22.0f));
        this.e = (ImageView) findViewById(Res.id("bdar_recommend_download"));
        this.f = (LoadingView) findViewById(Res.id("bdar_recommend_loading"));
        this.c = (ImageView) findViewById(Res.id("bdar_recommend_bg_image_selected"));
    }

    private void a(ARResource aRResource) {
        int downloadStatus = aRResource.getDownloadStatus();
        if (downloadStatus == -1) {
            this.e.setImageDrawable(Res.getDrawable("bdar_recommend_download"));
            this.e.setVisibility(0);
        } else if (downloadStatus == -3) {
            this.e.setImageDrawable(Res.getDrawable("bdar_recommend_download_failed"));
            this.e.setVisibility(0);
        } else if (downloadStatus == -2) {
            this.e.setVisibility(8);
        } else if (ARResource.isDownloading(downloadStatus)) {
            this.e.setVisibility(8);
        }
    }

    public void a() {
        this.e.setVisibility(8);
    }

    public void a(ARResource aRResource, boolean z) {
        a(aRResource);
        if (!z) {
            this.d.setProgress(0);
            return;
        }
        this.d.setAnimator(aRResource.getAnimator());
        this.d.setProgress(100);
    }

    public void a(ARResource aRResource, boolean z, boolean z2) {
        this.d.setAnimator(aRResource.getAnimator());
        String thumbnailUrl = aRResource.getThumbnailUrl();
        if (z) {
            this.a.setImageDrawable(null);
            d.a().a(thumbnailUrl, this.b);
        } else {
            d.a().a(thumbnailUrl, this.a);
            this.b.setImageDrawable(null);
        }
        if (!z) {
            this.c.setVisibility(8);
        } else if (z2) {
            this.c.setVisibility(8);
        } else {
            this.c.setVisibility(0);
        }
        a(aRResource);
        int downloadStatus = aRResource.getDownloadStatus();
        if (downloadStatus == -1 || downloadStatus == -3) {
            this.d.setVisibility(0);
            this.d.setProgress(0);
            this.f.setVisibility(8);
        } else if (downloadStatus != -2) {
            if (ARResource.isDownloading(downloadStatus)) {
                this.d.setVisibility(0);
                this.d.setProgress(downloadStatus);
                this.f.setVisibility(8);
            }
        } else {
            this.d.setVisibility(0);
            this.d.setProgress(100);
            if (!z) {
                this.d.setVisibility(0);
                this.f.setVisibility(8);
                return;
            }
            this.d.setVisibility(4);
            if (z2) {
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.ar.ui.rotateview.IRotateView
    public int getAngle() {
        return this.g.getAngle();
    }

    @Override // com.baidu.ar.ui.rotateview.IRotateView
    public void requestOrientation(Orientation orientation) {
        RotateViewUtils.requestOrientation(this.g, orientation);
    }

    @Override // com.baidu.ar.ui.rotateview.IRotateView
    public void requestOrientation(Orientation orientation, boolean z) {
        RotateViewUtils.requestOrientation(this.g, orientation, z);
    }

    @Override // com.baidu.ar.ui.rotateview.IRotateView
    public void setAngle(int i) {
        this.g.setAngle(i);
    }

    public void setProgress(int i) {
        this.d.setProgress(i);
    }
}
