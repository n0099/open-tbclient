package com.baidu.live.quick;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
    private AlphaGradientHListView but;
    private ImageView buu;
    private a buv;
    private a.InterfaceC0194a buw;

    public QuickImInputHeaderView(Context context) {
        super(context);
        init();
    }

    @Override // com.baidu.live.im.d.a
    public void setCallback(a.InterfaceC0194a interfaceC0194a) {
        this.buw = interfaceC0194a;
    }

    @Override // com.baidu.live.im.d.a
    @NonNull
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.d.a
    public void setData(List<String> list) {
        if (this.buv == null) {
            this.buv = new a();
            this.buv.setData(list);
            this.but.setAdapter((ListAdapter) this.buv);
        } else {
            this.buv.setData(list);
            this.buv.notifyDataSetChanged();
        }
        this.but.setSelection(0);
    }

    @Override // com.baidu.live.im.d.a
    public void setInVisible() {
        this.buu.setVisibility(8);
    }

    @Override // com.baidu.live.im.d.a
    public AlphaGradientHListView getListView() {
        return this.but;
    }

    @Override // com.baidu.live.im.d.a
    public void setTextColor(int i) {
        this.buv.setTextColor(i);
        this.buv.notifyDataSetChanged();
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.ala_quick_im_input_header, (ViewGroup) this, true);
        this.but = (AlphaGradientHListView) findViewById(a.f.lv);
        this.but.setShadowWidth(getResources().getDimensionPixelOffset(a.d.sdk_ds56));
        this.but.setNeedAlphaShade(true);
        this.but.setColor(getResources().getColor(a.c.sdk_white_alpha100), getResources().getColor(a.c.sdk_white_alpha0));
        this.but.setSelector(getResources().getDrawable(a.e.sdk_transparent_bg));
        this.but.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.quick.QuickImInputHeaderView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                if (QuickImInputHeaderView.this.buw != null) {
                    QuickImInputHeaderView.this.buw.E(QuickImInputHeaderView.this.buv.getItem(i), i);
                }
            }
        });
        this.buu = (ImageView) findViewById(a.f.iv_more);
        this.buu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.quick.QuickImInputHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QuickImInputHeaderView.this.buw != null) {
                    QuickImInputHeaderView.this.buw.Ov();
                }
            }
        });
    }

    /* loaded from: classes4.dex */
    private static class a extends BaseAdapter {
        private List<String> buy;
        private int textColor;

        private a() {
            this.textColor = 0;
        }

        public void setTextColor(int i) {
            this.textColor = i;
        }

        public void setData(List<String> list) {
            if (this.buy == null) {
                this.buy = new ArrayList();
            }
            this.buy.clear();
            if (list != null) {
                this.buy.addAll(list);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.buy != null) {
                return this.buy.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        public String getItem(int i) {
            return (this.buy == null || getCount() <= i) ? "" : this.buy.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.ala_quick_im_input_header_item, (ViewGroup) null);
                b bVar2 = new b();
                bVar2.textView = (TextView) view.findViewById(a.f.f1855tv);
                if (this.textColor != 0) {
                    bVar2.textView.setTextColor(this.textColor);
                    bVar2.textView.setBackgroundDrawable(viewGroup.getContext().getResources().getDrawable(a.e.sdk_im_round_quick_bg));
                }
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.textView.setText(getItem(i));
            ((FrameLayout.LayoutParams) bVar.textView.getLayoutParams()).rightMargin = viewGroup.getResources().getDimensionPixelOffset(i == getCount() + (-1) ? a.d.sdk_ds48 : a.d.sdk_ds16);
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
