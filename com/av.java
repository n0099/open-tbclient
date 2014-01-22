package com;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import java.util.List;
/* loaded from: classes.dex */
public class av extends ArrayAdapter {
    private SocialShareConfig a;

    public av(Context context, List list) {
        super(context, 0, list);
        this.a = SocialShareConfig.getInstance(context);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ax axVar;
        TextView textView;
        TextView textView2;
        if (view == null || view.getTag() == null) {
            axVar = new ax();
            view = LayoutInflater.from(getContext()).inflate(i.a(getContext(), "bdsocialshare_sharemenuweixinitem"), (ViewGroup) null);
            view.setBackgroundResource(i.b(getContext(), "bdsocialshare_sharemenu_item_click"));
            axVar.a = (TextView) view.findViewById(i.d(getContext(), "sharemenuweixin_itemtext"));
            textView = axVar.a;
            textView.setTextColor(Color.parseColor(i.a(getContext())));
        } else {
            axVar = (ax) view.getTag();
        }
        textView2 = axVar.a;
        textView2.setText(this.a.getString(((MediaType) getItem(i)).toString()));
        return view;
    }
}
