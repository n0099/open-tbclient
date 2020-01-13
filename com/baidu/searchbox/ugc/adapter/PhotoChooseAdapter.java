package com.baidu.searchbox.ugc.adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.model.ImageStruct;
import com.baidu.searchbox.ugc.utils.ResourceUtils;
import com.baidu.searchbox.ugc.utils.SelectUtil;
import com.baidu.searchbox.ugc.utils.UiBaseUtils;
import com.facebook.drawee.a.a.c;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.b;
import com.facebook.imagepipeline.common.d;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.List;
/* loaded from: classes12.dex */
public class PhotoChooseAdapter extends BaseAdapter {
    private Activity mContext;
    private int mHorizontalSpacing;
    private DeletePhotoListener mListener;
    private int mMax = 3;
    private int mNumColumns;

    /* loaded from: classes12.dex */
    public interface DeletePhotoListener {
        void setPublishStatus();
    }

    public void setListener(DeletePhotoListener deletePhotoListener) {
        this.mListener = deletePhotoListener;
    }

    public PhotoChooseAdapter(Context context, int i, int i2) {
        this.mContext = (Activity) context;
        this.mHorizontalSpacing = i;
        this.mNumColumns = i2;
    }

    public void setMaxCount(int i) {
        this.mMax = i;
    }

    public boolean isMorePosition(int i) {
        return i == getCount() + (-1) && SelectUtil.getSelectedCount() < this.mMax;
    }

    public void deletePhoto(ImageStruct imageStruct) {
        if (imageStruct != null) {
            SelectUtil.removeSelectedImags(imageStruct);
            if (SelectUtil.getSelectedCount() == 0 && this.mListener != null) {
                this.mListener.setPublishStatus();
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int selectedCount = SelectUtil.getSelectedCount();
        if (selectedCount < this.mMax) {
            return selectedCount + 1;
        }
        if (selectedCount >= this.mMax) {
            return this.mMax;
        }
        return selectedCount;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public Uri getItem(int i) {
        return SelectUtil.getSeletedImages().get(i).contentUri;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(this.mContext).inflate(R.layout.ugc_photo_choose_layout, viewGroup, false);
            viewHolder.img = (SimpleDraweeView) view.findViewById(ResourceUtils.getResIdByName("ugc_img"));
            viewHolder.closeImg = (ImageView) view.findViewById(ResourceUtils.getResIdByName("ugc_delete"));
            viewHolder.photoTypeBg = (RelativeLayout) view.findViewById(ResourceUtils.getResIdByName("ugc_right_bottom_bg"));
            viewHolder.photoType = (TextView) view.findViewById(ResourceUtils.getResIdByName("ugc_right_bottom_tip"));
            if (viewHolder.img != null) {
                viewHolder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
                int displayWidth = ((DeviceUtil.ScreenInfo.getDisplayWidth(this.mContext) - DeviceUtil.ScreenInfo.dp2px(this.mContext, 30.0f)) - (this.mHorizontalSpacing * (this.mNumColumns - 1))) / this.mNumColumns;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewHolder.img.getLayoutParams();
                layoutParams.width = displayWidth;
                layoutParams.height = displayWidth;
                viewHolder.img.setLayoutParams(layoutParams);
                UiBaseUtils.setViewBackgroundDrawable(viewHolder.img, ContextCompat.getDrawable(this.mContext, R.drawable.ugc_img_stroke_bg));
            }
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        int displayWidth2 = DeviceUtil.ScreenInfo.getDisplayWidth(this.mContext) / 3;
        int displayWidth3 = DeviceUtil.ScreenInfo.getDisplayWidth(this.mContext) / 3;
        UiBaseUtils.setImageResource(viewHolder.closeImg, R.drawable.ugc_delete_selected_img);
        UiBaseUtils.setVisibility(viewHolder.closeImg, 8);
        if (!isMorePosition(i)) {
            UiBaseUtils.setVisibility(viewHolder.closeImg, 0);
        }
        if (isMorePosition(i)) {
            UiBaseUtils.setVisibility(viewHolder.photoTypeBg, 8);
            UiBaseUtils.setViewBackgroundDrawable(viewHolder.img, ContextCompat.getDrawable(this.mContext, R.drawable.ugc_add_photo_stroke_bg));
            UiBaseUtils.setImageResource(viewHolder.img, R.drawable.ugc_add_localalbum_selector);
        } else {
            Uri item = getItem(i);
            if (item != null) {
                if (SelectUtil.supportGifLongImg) {
                    if (SelectUtil.isGif(item)) {
                        UiBaseUtils.setVisibility(viewHolder.photoTypeBg, 0);
                        UiBaseUtils.setTextStringResource(viewHolder.photoType, R.string.ugc_album_gif_photo);
                    } else if (SelectUtil.isLargeImage(item)) {
                        UiBaseUtils.setVisibility(viewHolder.photoTypeBg, 0);
                        UiBaseUtils.setTextStringResource(viewHolder.photoType, R.string.ugc_album_large_photo);
                    } else {
                        UiBaseUtils.setVisibility(viewHolder.photoTypeBg, 8);
                    }
                } else {
                    UiBaseUtils.setVisibility(viewHolder.photoTypeBg, 8);
                }
                c.dkj().N(item);
                ImageRequest drm = ImageRequestBuilder.X(item).c(new d((int) (displayWidth2 / 2.0f), (int) (displayWidth3 / 2.0f))).a(b.dmW().vk(true).dne()).drm();
                if (viewHolder.img != null) {
                    viewHolder.img.setController(c.dkh().vd(false).c(viewHolder.img.getController()).be(drm).dkY());
                }
            }
        }
        UiBaseUtils.setOnClickListener(viewHolder.closeImg, new View.OnClickListener() { // from class: com.baidu.searchbox.ugc.adapter.PhotoChooseAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                List<ImageStruct> seletedImages = SelectUtil.getSeletedImages();
                if (seletedImages != null && seletedImages.size() > i) {
                    PhotoChooseAdapter.this.deletePhoto(seletedImages.get(i));
                }
            }
        });
        return view;
    }

    /* loaded from: classes12.dex */
    public class ViewHolder {
        public ImageView closeImg;
        public SimpleDraweeView img;
        public TextView photoType;
        public RelativeLayout photoTypeBg;

        public ViewHolder() {
        }
    }
}
