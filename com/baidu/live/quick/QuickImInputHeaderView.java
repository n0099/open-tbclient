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
    private AlphaGradientHListView bgZ;
    private a bha;
    private a.InterfaceC0176a bhb;

    public QuickImInputHeaderView(Context context) {
        super(context);
        init();
    }

    @Override // com.baidu.live.im.d.a
    public void setCallback(a.InterfaceC0176a interfaceC0176a) {
        this.bhb = interfaceC0176a;
    }

    @Override // com.baidu.live.im.d.a
    @NonNull
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.d.a
    public void setData(List<String> list) {
        if (this.bha == null) {
            this.bha = new a();
            this.bha.setData(list);
            this.bgZ.setAdapter((ListAdapter) this.bha);
        } else {
            this.bha.setData(list);
            this.bha.notifyDataSetChanged();
        }
        this.bgZ.setSelection(0);
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_quick_im_input_header, (ViewGroup) this, true);
        this.bgZ = (AlphaGradientHListView) findViewById(a.g.lv);
        this.bgZ.setShadowWidth(getResources().getDimensionPixelOffset(a.e.sdk_ds56));
        this.bgZ.setNeedAlphaShade(true);
        this.bgZ.setColor(getResources().getColor(a.d.sdk_white_alpha100), getResources().getColor(a.d.sdk_white_alpha0));
        this.bgZ.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        this.bgZ.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.quick.QuickImInputHeaderView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                if (QuickImInputHeaderView.this.bhb != null) {
                    QuickImInputHeaderView.this.bhb.C(QuickImInputHeaderView.this.bha.getItem(i), i);
                }
            }
        });
        findViewById(a.g.iv_more).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.quick.QuickImInputHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QuickImInputHeaderView.this.bhb != null) {
                    QuickImInputHeaderView.this.bhb.Kd();
                }
            }
        });
    }

    /* loaded from: classes7.dex */
    private static class a extends BaseAdapter {
        private List<String> bhd;

        private a() {
        }

        public void setData(List<String> list) {
            if (this.bhd == null) {
                this.bhd = new ArrayList();
            }
            this.bhd.clear();
            if (list != null) {
                this.bhd.addAll(list);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bhd != null) {
                return this.bhd.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        public String getItem(int i) {
            return (this.bhd == null || getCount() <= i) ? "" : this.bhd.get(i);
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
                bVar2.textView = (TextView) view.findViewById(a.g.f970tv);
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
