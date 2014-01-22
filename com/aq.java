package com;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import java.util.List;
/* loaded from: classes.dex */
public class aq extends ArrayAdapter {
    private SocialShareConfig a;

    public aq(Context context, List list) {
        super(context, 0, list);
        this.a = SocialShareConfig.getInstance(context);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        as asVar;
        TextView textView;
        ImageView imageView;
        TextView textView2;
        if (view == null || view.getTag() == null) {
            asVar = new as(this);
            view = LayoutInflater.from(getContext()).inflate(i.a(getContext(), "bdsocialshare_sharemenulistitem"), (ViewGroup) null);
            view.setBackgroundResource(i.b(getContext(), "bdsocialshare_sharemenu_item_click"));
            asVar.b = (ImageView) view.findViewById(i.d(getContext(), "sharemenulist_iconview"));
            asVar.c = (TextView) view.findViewById(i.d(getContext(), "sharemenulist_icontext"));
            textView = asVar.c;
            textView.setTextColor(Color.parseColor(i.a(getContext())));
        } else {
            asVar = (as) view.getTag();
        }
        MediaType mediaType = (MediaType) getItem(i);
        int c = i.c(getContext(), "bdsocialshare_" + mediaType.toString());
        imageView = asVar.b;
        imageView.setImageResource(c);
        textView2 = asVar.c;
        textView2.setText(this.a.getString(mediaType.toString()));
        return view;
    }
}
