package com.baidu.searchbox.ugc.publishmenu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.utils.ResourceUtils;
import com.baidu.searchbox.ugc.utils.UgcUiUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class PublishMenuAdapter extends BaseAdapter {
    private Context mContext;
    private List<ItemInfo> mList = new ArrayList();

    public PublishMenuAdapter(Context context) {
        this.mContext = context;
    }

    public void updateAll(List<ItemInfo> list) {
        this.mList.clear();
        if (list != null) {
            this.mList.addAll(list);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public ItemInfo getItem(int i) {
        return this.mList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyHolder myHolder;
        if (view == null) {
            view = View.inflate(this.mContext, R.layout.ugc_publish_menu_dialog_item, null);
            UgcUiUtils.setViewColor(view, R.color.ugc_white);
            MyHolder myHolder2 = new MyHolder(view);
            view.setTag(myHolder2);
            myHolder = myHolder2;
        } else {
            myHolder = (MyHolder) view.getTag();
        }
        myHolder.bind(this.mList.get(i));
        return view;
    }

    /* loaded from: classes13.dex */
    private class MyHolder {
        public ImageView iconIv;
        public TextView nameTv;

        public MyHolder(View view) {
            this.nameTv = (TextView) view.findViewById(ResourceUtils.getResIdByName("ugc_item_name_tv"));
            this.iconIv = (ImageView) view.findViewById(ResourceUtils.getResIdByName("ugc_item_icon_iv"));
        }

        public void bind(ItemInfo itemInfo) {
            if (this.nameTv != null) {
                this.nameTv.setText(itemInfo.nameId);
            }
            UgcUiUtils.setTextResource(this.nameTv, R.color.ugc_publish_menu_text_selector);
            UgcUiUtils.setImageResource(this.iconIv, itemInfo.iconId);
        }
    }
}
