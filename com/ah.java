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
public class ah extends ArrayAdapter {
    private SocialShareConfig a;

    public ah(Context context, List list) {
        super(context, 0, list);
        this.a = SocialShareConfig.getInstance(context);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ap apVar;
        TextView textView;
        ImageView imageView;
        TextView textView2;
        if (view == null || view.getTag() == null) {
            apVar = new ap(this);
            view = LayoutInflater.from(getContext()).inflate(i.a(getContext(), "bdsocialshare_sharemenugriditem"), (ViewGroup) null);
            apVar.b = (ImageView) view.findViewById(i.d(getContext(), "sharemenugrid_iconview"));
            apVar.c = (TextView) view.findViewById(i.d(getContext(), "sharemenugrid_icontext"));
            textView = apVar.c;
            textView.setTextColor(Color.parseColor(i.a(getContext())));
        } else {
            apVar = (ap) view.getTag();
        }
        MediaType mediaType = (MediaType) getItem(i);
        int c = i.c(getContext(), "bdsocialshare_" + mediaType.toString());
        imageView = apVar.b;
        imageView.setImageResource(c);
        textView2 = apVar.c;
        textView2.setText(this.a.getString(mediaType.toString()));
        return view;
    }
}
