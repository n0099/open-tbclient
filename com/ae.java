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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ae extends ArrayAdapter {
    private SocialShareConfig a;
    private List b;

    /* loaded from: classes.dex */
    class a {
        private ImageView b;
        private TextView c;

        private a() {
        }
    }

    public ae(Context context, List list, int i) {
        super(context, 0, list);
        this.a = SocialShareConfig.getInstance(context);
        this.b = new ArrayList();
        int i2 = i * 12;
        int i3 = i2 + 12;
        while (i2 < list.size() && i2 < i3) {
            this.b.add(list.get(i2));
            i2++;
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            a aVar2 = new a();
            view = LayoutInflater.from(getContext().getApplicationContext()).inflate(p.a(getContext(), "bdsocialshare_sharemenugriditem"), (ViewGroup) null);
            aVar2.b = (ImageView) view.findViewById(p.i(getContext(), "sharemenugrid_iconview"));
            aVar2.c = (TextView) view.findViewById(p.i(getContext(), "sharemenugrid_icontext"));
            aVar2.c.setTextColor(Color.parseColor(p.a(getContext())));
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        MediaType item = getItem(i);
        aVar.b.setImageResource(p.h(getContext(), "bdsocialshare_" + item.toString()));
        aVar.c.setText(this.a.getString(item.toString()));
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* renamed from: rl */
    public MediaType getItem(int i) {
        return (MediaType) this.b.get(i);
    }
}
