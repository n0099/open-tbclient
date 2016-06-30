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
public class ag extends ArrayAdapter {
    private SocialShareConfig a;

    /* loaded from: classes.dex */
    static class a {
        private TextView a;

        private a() {
        }
    }

    public ag(Context context, List list) {
        super(context, 0, list);
        this.a = SocialShareConfig.getInstance(context);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            aVar = new a();
            view = LayoutInflater.from(getContext().getApplicationContext()).inflate(p.g(getContext(), "bdsocialshare_sharemenuweixinitem"), (ViewGroup) null);
            view.setBackgroundResource(p.h(getContext(), "bdsocialshare_sharemenu_item_click"));
            aVar.a = (TextView) view.findViewById(p.j(getContext(), "sharemenuweixin_itemtext"));
            aVar.a.setTextColor(Color.parseColor(p.a(getContext())));
        } else {
            aVar = (a) view.getTag();
        }
        aVar.a.setText(this.a.getString(((MediaType) getItem(i)).toString()));
        return view;
    }
}
