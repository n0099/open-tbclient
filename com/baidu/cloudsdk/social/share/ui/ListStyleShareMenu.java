package com.baidu.cloudsdk.social.share.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.cloudsdk.assets.DrawableUtils;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.share.SocialShare;
import java.util.List;
/* loaded from: classes.dex */
public class ListStyleShareMenu extends ay {

    /* loaded from: classes.dex */
    class a extends ArrayAdapter {
        public a(Context context, List list) {
            super(context, 0, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            String mediaType = ((MediaType) getItem(i)).toString();
            LinearLayout linearLayout = view;
            if (view == null) {
                Context context = getContext();
                int fix720px = DrawableUtils.fix720px(context, 96);
                LinearLayout linearLayout2 = new LinearLayout(context);
                linearLayout2.setOnClickListener(ListStyleShareMenu.this.mOnClickListener);
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(new int[]{16842919}, new ColorDrawable(ListStyleShareMenu.this.mMenuTheme.j()));
                stateListDrawable.addState(new int[0], null);
                linearLayout2.setBackgroundDrawable(stateListDrawable);
                linearLayout2.setTag(mediaType);
                linearLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                ImageView imageView = new ImageView(context);
                MediaIconManager mediaIconManager = MediaIconManager.getInstance(context);
                imageView.setImageDrawable(ListStyleShareMenu.this.mIsNightMode ? mediaIconManager.getNightModeIcon(mediaType) : mediaIconManager.getNormalIcon(mediaType));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(fix720px, fix720px);
                layoutParams.leftMargin = DrawableUtils.fix720px(context, 26);
                layoutParams.rightMargin = DrawableUtils.fix720px(context, 14);
                linearLayout2.addView(imageView, layoutParams);
                TextView textView = new TextView(context);
                textView.setTextColor(ListStyleShareMenu.this.mMenuTheme.h());
                textView.setTextSize(0, DrawableUtils.fix720px(context, 30));
                textView.setText(ListStyleShareMenu.this.mConfig.getString(mediaType));
                textView.setGravity(16);
                linearLayout2.addView(textView, new LinearLayout.LayoutParams(-2, fix720px));
                linearLayout = linearLayout2;
            }
            return linearLayout;
        }
    }

    public ListStyleShareMenu(Context context, SocialShare.Theme theme, View.OnClickListener onClickListener) {
        super(context, theme, onClickListener);
    }

    @Override // defpackage.ay
    protected View getSocialMediaListView(Context context) {
        Drawable drawable = DrawableUtils.getDrawable(context, this.mConfig.getAssetFileName(this.mMenuTheme.g()));
        ListView listView = new ListView(context);
        listView.setCacheColorHint(0);
        listView.setDivider(drawable);
        listView.setAdapter((ListAdapter) new a(context, this.mConfig.getSupportedMediaTypes()));
        return listView;
    }
}
