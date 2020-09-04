package com.baidu.live.quick;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.im.d.a;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.view.AlphaGradientHListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class QuickImInputHeaderView extends RelativeLayout implements com.baidu.live.im.d.a {
    private AlphaGradientHListView bhc;
    private a bhd;
    private a.InterfaceC0176a bhe;

    public QuickImInputHeaderView(Context context) {
        super(context);
        init();
    }

    @Override // com.baidu.live.im.d.a
    public void setCallback(a.InterfaceC0176a interfaceC0176a) {
        this.bhe = interfaceC0176a;
    }

    @Override // com.baidu.live.im.d.a
    @NonNull
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.d.a
    public void setData(List<String> list) {
        if (this.bhd == null) {
            this.bhd = new a();
            this.bhd.setData(list);
            this.bhc.setAdapter((ListAdapter) this.bhd);
        } else {
            this.bhd.setData(list);
            this.bhd.notifyDataSetChanged();
        }
        this.bhc.setSelection(0);
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_quick_im_input_header, (ViewGroup) this, true);
        this.bhc = (AlphaGradientHListView) findViewById(a.g.lv);
        this.bhc.setShadowWidth(getResources().getDimensionPixelOffset(a.e.sdk_ds56));
        this.bhc.setNeedAlphaShade(true);
        this.bhc.setColor(getResources().getColor(a.d.sdk_white_alpha100), getResources().getColor(a.d.sdk_white_alpha0));
        this.bhc.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        this.bhc.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.quick.QuickImInputHeaderView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                if (QuickImInputHeaderView.this.bhe != null) {
                    QuickImInputHeaderView.this.bhe.C(QuickImInputHeaderView.this.bhd.getItem(i), i);
                }
            }
        });
        findViewById(a.g.iv_more).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.quick.QuickImInputHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QuickImInputHeaderView.this.bhe != null) {
                    QuickImInputHeaderView.this.bhe.Kd();
                }
            }
        });
    }

    /* loaded from: classes7.dex */
    private static class a extends BaseAdapter {
        private List<String> bhg;

        private a() {
        }

        public void setData(List<String> list) {
            if (this.bhg == null) {
                this.bhg = new ArrayList();
            }
            this.bhg.clear();
            if (list != null) {
                this.bhg.addAll(list);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bhg != null) {
                return this.bhg.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        public String getItem(int i) {
            return (this.bhg == null || getCount() <= i) ? "" : this.bhg.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(a.h.ala_quick_im_input_header_item, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.textView = (TextView) view.findViewById(a.g.f969tv);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.textView.setText(getItem(i));
            ((FrameLayout.LayoutParams) bVar.textView.getLayoutParams()).rightMargin = viewGroup.getResources().getDimensionPixelOffset(i == getCount() + (-1) ? a.e.sdk_ds48 : a.e.sdk_ds16);
            return view;
        }
    }

    /* loaded from: classes7.dex */
    private static class b {
        TextView textView;

        private b() {
        }
    }
}
