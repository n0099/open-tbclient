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
/* loaded from: classes4.dex */
public class QuickImInputHeaderView extends RelativeLayout implements com.baidu.live.im.d.a {
    private AlphaGradientHListView bkb;
    private a bkc;
    private a.InterfaceC0178a bkd;

    public QuickImInputHeaderView(Context context) {
        super(context);
        init();
    }

    @Override // com.baidu.live.im.d.a
    public void setCallback(a.InterfaceC0178a interfaceC0178a) {
        this.bkd = interfaceC0178a;
    }

    @Override // com.baidu.live.im.d.a
    @NonNull
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.d.a
    public void setData(List<String> list) {
        if (this.bkc == null) {
            this.bkc = new a();
            this.bkc.setData(list);
            this.bkb.setAdapter((ListAdapter) this.bkc);
        } else {
            this.bkc.setData(list);
            this.bkc.notifyDataSetChanged();
        }
        this.bkb.setSelection(0);
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_quick_im_input_header, (ViewGroup) this, true);
        this.bkb = (AlphaGradientHListView) findViewById(a.g.lv);
        this.bkb.setShadowWidth(getResources().getDimensionPixelOffset(a.e.sdk_ds56));
        this.bkb.setNeedAlphaShade(true);
        this.bkb.setColor(getResources().getColor(a.d.sdk_white_alpha100), getResources().getColor(a.d.sdk_white_alpha0));
        this.bkb.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        this.bkb.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.quick.QuickImInputHeaderView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                if (QuickImInputHeaderView.this.bkd != null) {
                    QuickImInputHeaderView.this.bkd.C(QuickImInputHeaderView.this.bkc.getItem(i), i);
                }
            }
        });
        findViewById(a.g.iv_more).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.quick.QuickImInputHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QuickImInputHeaderView.this.bkd != null) {
                    QuickImInputHeaderView.this.bkd.KK();
                }
            }
        });
    }

    /* loaded from: classes4.dex */
    private static class a extends BaseAdapter {
        private List<String> bkf;

        private a() {
        }

        public void setData(List<String> list) {
            if (this.bkf == null) {
                this.bkf = new ArrayList();
            }
            this.bkf.clear();
            if (list != null) {
                this.bkf.addAll(list);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bkf != null) {
                return this.bkf.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        public String getItem(int i) {
            return (this.bkf == null || getCount() <= i) ? "" : this.bkf.get(i);
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
                bVar2.textView = (TextView) view.findViewById(a.g.f968tv);
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

    /* loaded from: classes4.dex */
    private static class b {
        TextView textView;

        private b() {
        }
    }
}
