package com.baidu.cloudsdk.social.share.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.cloudsdk.assets.DrawableUtils;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.cloudsdk.social.share.SocialShare;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class WeixinShareMenu extends ay {

    /* loaded from: classes.dex */
    class a extends ArrayAdapter {
        private Drawable b;

        public a(Context context, List list) {
            super(context, 0, list);
            this.b = new ColorDrawable(WeixinShareMenu.this.mMenuTheme.j());
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            MediaType mediaType = (MediaType) getItem(i);
            if (view == null) {
                Context context = getContext();
                TextView textView = new TextView(context);
                textView.setGravity(17);
                textView.setTextColor(WeixinShareMenu.this.mMenuTheme.h());
                textView.setTextSize(0, DrawableUtils.fix720px(context, 32));
                textView.setText(WeixinShareMenu.this.mConfig.getString("share_to") + WeixinShareMenu.this.mConfig.getString(mediaType.toString()));
                textView.setTag(mediaType.toString());
                textView.setOnClickListener(WeixinShareMenu.this.mOnClickListener);
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(new int[]{16842919}, this.b);
                textView.setBackgroundDrawable(stateListDrawable);
                textView.setLayoutParams(new AbsListView.LayoutParams(-1, DrawableUtils.fix720px(context, SocialAPIErrorCodes.ERROR_MISS_ACCESS_TOKEN)));
                return textView;
            }
            return view;
        }
    }

    public WeixinShareMenu(Context context, SocialShare.Theme theme, View.OnClickListener onClickListener) {
        super(context, theme, onClickListener);
    }

    @Override // defpackage.ay
    protected View getSocialMediaListView(Context context) {
        Drawable drawable = DrawableUtils.getDrawable(context, this.mConfig.getAssetFileName(this.mMenuTheme.g()));
        ListView listView = new ListView(context);
        listView.setCacheColorHint(0);
        listView.setDivider(drawable);
        ArrayList arrayList = new ArrayList();
        arrayList.add(MediaType.WEIXIN_FRIEND);
        arrayList.add(MediaType.WEIXIN_TIMELINE);
        listView.setAdapter((ListAdapter) new a(context, arrayList));
        return listView;
    }
}
