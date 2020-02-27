package com.baidu.searchbox.ugc.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.ugc.album.R;
import com.baidu.searchbox.ugc.model.ImageGroup;
import com.baidu.searchbox.ugc.utils.ResourceUtils;
import com.baidu.searchbox.ugc.utils.UiBaseUtils;
import com.facebook.drawee.a.a.c;
import com.facebook.drawee.controller.a;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.d;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class AlbumListAdapter extends BaseAdapter {
    private Activity mContext;
    private List<ImageGroup> mList;

    public AlbumListAdapter(Activity activity, List<ImageGroup> list) {
        this.mList = new ArrayList();
        this.mContext = activity;
        this.mList = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList == null) {
            return 0;
        }
        return this.mList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i > this.mList.size()) {
            return null;
        }
        return this.mList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            ViewHolder viewHolder2 = new ViewHolder();
            view = LayoutInflater.from(this.mContext).inflate(R.layout.ugc_album_item, (ViewGroup) null);
            viewHolder2.img = (SimpleDraweeView) view.findViewById(ResourceUtils.getResIdByName("ugc_img"));
            viewHolder2.title = (TextView) view.findViewById(ResourceUtils.getResIdByName("ugc_title"));
            viewHolder2.numbers = (TextView) view.findViewById(ResourceUtils.getResIdByName("ugc_number"));
            UiBaseUtils.setTextColorResource(viewHolder2.title, R.color.ugc_album_unable_click_color);
            UiBaseUtils.setTextColorResource(viewHolder2.numbers, R.color.ugc_album_layer_text_color);
            UiBaseUtils.setViewColorResource(view.findViewById(ResourceUtils.getResIdByName("ugc_album_line")), R.color.ugc_album_line_color);
            view.setTag(viewHolder2);
            viewHolder = viewHolder2;
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        UiBaseUtils.setViewDrawableResource(view, R.drawable.ugc_album_item_selector);
        ImageGroup imageGroup = this.mList.get(i);
        int dp2px = DeviceUtil.ScreenInfo.dp2px(this.mContext, 50.0f);
        int dp2px2 = DeviceUtil.ScreenInfo.dp2px(this.mContext, 50.0f);
        if (imageGroup != null) {
            UiBaseUtils.setTextString(viewHolder.title, imageGroup.getBucketName());
            if (imageGroup.images != null) {
                UiBaseUtils.setTextString(viewHolder.numbers, imageGroup.images.size() + this.mContext.getString(R.string.ugc_album_pages));
                if (imageGroup.images.get(0) != null && imageGroup.images.get(0).contentUri != null) {
                    ImageRequestBuilder Y = ImageRequestBuilder.Y(imageGroup.images.get(0).contentUri);
                    Y.c(new d((int) (dp2px / 2.0f), (int) (dp2px2 / 2.0f)));
                    Y.vw(true);
                    a dmj = c.dlw().vh(false).bg(Y.dsA()).c(viewHolder.img.getController()).dmn();
                    if (viewHolder.img != null) {
                        viewHolder.img.setController(dmj);
                    }
                }
            }
        }
        return view;
    }

    /* loaded from: classes13.dex */
    public class ViewHolder {
        SimpleDraweeView img;
        TextView numbers;
        TextView title;

        public ViewHolder() {
        }
    }
}
