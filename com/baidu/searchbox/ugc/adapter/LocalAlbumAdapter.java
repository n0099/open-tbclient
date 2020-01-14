package com.baidu.searchbox.ugc.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.picture.component.HugePhotoDraweeView;
import com.baidu.searchbox.picture.component.HugePhotoUtils;
import com.baidu.searchbox.picture.component.ImageSource;
import com.baidu.searchbox.ugc.album.R;
import com.baidu.searchbox.ugc.model.ImageStruct;
import com.baidu.searchbox.ugc.utils.ResourceUtils;
import com.baidu.searchbox.ugc.utils.SelectUtil;
import com.baidu.searchbox.ugc.utils.UiBaseUtils;
import com.baidu.searchbox.ui.UIRuntime;
import com.facebook.drawee.controller.b;
import com.facebook.drawee.controller.c;
import com.facebook.drawee.drawable.p;
import com.facebook.imagepipeline.common.d;
import com.facebook.imagepipeline.g.a;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class LocalAlbumAdapter extends PagerAdapter {
    private static final float LONG_PIC_DISTINGUISH_RATE = 1.6f;
    public static final float MAX_BITMAP_SIZE = 10240.0f;
    private Activity mContext;
    private ClickPagerViewListener mListener;
    private List<ImageStruct> mList = new ArrayList();
    private int[] maxTextureSize = new int[1];

    /* loaded from: classes12.dex */
    public interface ClickPagerViewListener {
        void clickContainer();
    }

    public void setListener(ClickPagerViewListener clickPagerViewListener) {
        this.mListener = clickPagerViewListener;
    }

    public LocalAlbumAdapter(Activity activity, List<ImageStruct> list) {
        this.mContext = activity;
        setData(list);
    }

    public void setData(List<ImageStruct> list) {
        this.mList = new ArrayList(list);
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.mList == null) {
            return 0;
        }
        return this.mList.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Uri uri = this.mList.get(i).contentUri;
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.ugc_photo_preview_item, viewGroup, false);
        HugePhotoDraweeView hugePhotoDraweeView = (HugePhotoDraweeView) inflate.findViewById(ResourceUtils.getResIdByName("ugc_photo"));
        c controllerListener = getControllerListener(hugePhotoDraweeView);
        UiBaseUtils.setViewColorResource(inflate, R.color.ugc_common_black);
        UiBaseUtils.setViewColorResource(inflate.findViewById(ResourceUtils.getResIdByName("ugc_photo_item_root")), R.color.ugc_common_black);
        UiBaseUtils.setViewColorResource(inflate, R.color.ugc_common_black);
        UiBaseUtils.setViewColorResource(inflate.findViewById(R.id.ugc_photo_item_root), R.color.ugc_common_black);
        ImageRequestBuilder X = ImageRequestBuilder.X(uri);
        X.c(new d(DeviceUtil.ScreenInfo.getDisplayWidth(this.mContext), DeviceUtil.ScreenInfo.getDisplayHeight(this.mContext), 10240.0f));
        X.vs(true);
        hugePhotoDraweeView.setController(com.facebook.drawee.a.a.c.dkj().vd(SelectUtil.supportGifLongImg).be(X.dro()).c(controllerListener).c(hugePhotoDraweeView.getController()).dla());
        hugePhotoDraweeView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ugc.adapter.LocalAlbumAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LocalAlbumAdapter.this.mListener != null) {
                    LocalAlbumAdapter.this.mListener.clickContainer();
                }
            }
        });
        viewGroup.addView(inflate);
        return inflate;
    }

    private c getControllerListener(final HugePhotoDraweeView hugePhotoDraweeView) {
        return new b() { // from class: com.baidu.searchbox.ugc.adapter.LocalAlbumAdapter.2
            @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
            public void onSubmit(String str, Object obj) {
                super.onSubmit(str, obj);
            }

            @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
            public void onFinalImageSet(String str, Object obj, Animatable animatable) {
                super.onFinalImageSet(str, obj, animatable);
                if (obj instanceof com.facebook.imagepipeline.g.d) {
                    hugePhotoDraweeView.setIsDynamicBitmap(false);
                    hugePhotoDraweeView.setZoomEnabled(true);
                    Bitmap dpd = ((com.facebook.imagepipeline.g.d) obj).dpd();
                    LocalAlbumAdapter.this.maxTextureSize = HugePhotoUtils.getMaxTextureSize();
                    ImageSource cachedBitmap = ImageSource.cachedBitmap(dpd);
                    if (dpd.getWidth() >= LocalAlbumAdapter.this.maxTextureSize[0] || dpd.getHeight() >= LocalAlbumAdapter.this.maxTextureSize[0]) {
                        cachedBitmap.tilingEnabled();
                    } else {
                        cachedBitmap.tilingDisabled();
                    }
                    hugePhotoDraweeView.setImage(cachedBitmap);
                    LocalAlbumAdapter.this.longPicDisplayMode(hugePhotoDraweeView, dpd);
                } else if (obj instanceof a) {
                    hugePhotoDraweeView.setIsDynamicBitmap(true);
                    hugePhotoDraweeView.setZoomEnabled(false);
                    hugePhotoDraweeView.getHierarchy().b(p.b.lMg);
                }
            }

            @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
            public void onFailure(String str, Throwable th) {
                super.onFailure(str, th);
            }
        };
    }

    public void longPicDisplayMode(HugePhotoDraweeView hugePhotoDraweeView, Bitmap bitmap) {
        int displayWidth = DeviceUtil.ScreenInfo.getDisplayWidth(UIRuntime.getAppContext());
        int displayHeight = DeviceUtil.ScreenInfo.getDisplayHeight(UIRuntime.getAppContext());
        if (bitmap != null && bitmap.getHeight() > displayHeight * 1.6f) {
            float width = bitmap.getWidth() == 0 ? 1.0f : displayWidth / bitmap.getWidth();
            hugePhotoDraweeView.setDoubleTapZoomScale(width);
            hugePhotoDraweeView.setScaleAndCenter(width, new PointF(displayWidth / 2, 0.0f));
        }
    }
}
