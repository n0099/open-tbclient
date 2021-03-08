package com.baidu.live.yuyinquick;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.live.im.d.a;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.view.AlphaGradientHListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class QuickImInputHeaderView extends RelativeLayout implements com.baidu.live.im.d.a {
    private AlphaGradientHListView bzp;
    private a.InterfaceC0186a bzs;
    private a cfC;

    public QuickImInputHeaderView(Context context) {
        super(context);
        init();
    }

    @Override // com.baidu.live.im.d.a
    public void setCallback(a.InterfaceC0186a interfaceC0186a) {
        this.bzs = interfaceC0186a;
    }

    @Override // com.baidu.live.im.d.a
    @NonNull
    public View getView() {
        return this;
    }

    @Override // com.baidu.live.im.d.a
    public AlphaGradientHListView getListView() {
        return this.bzp;
    }

    @Override // com.baidu.live.im.d.a
    public void setTextColor(int i) {
    }

    @Override // com.baidu.live.im.d.a
    public void setData(List<String> list) {
        if (this.cfC == null) {
            this.cfC = new a();
            this.cfC.setData(list);
            this.bzp.setAdapter((ListAdapter) this.cfC);
        } else {
            this.cfC.setData(list);
            this.cfC.notifyDataSetChanged();
        }
        this.bzp.setSelection(0);
    }

    @Override // com.baidu.live.im.d.a
    public void setInVisible() {
    }

    private void init() {
        setBackgroundColor(0);
        LayoutInflater.from(getContext()).inflate(a.g.ala_quick_im_input_header, (ViewGroup) this, true);
        this.bzp = (AlphaGradientHListView) findViewById(a.f.lv);
        this.bzp.setShadowWidth(getResources().getDimensionPixelOffset(a.d.sdk_ds56));
        this.bzp.setNeedAlphaShade(true);
        this.bzp.setColor(getResources().getColor(a.c.sdk_white_alpha100), getResources().getColor(a.c.sdk_white_alpha0));
        this.bzp.setSelector(getResources().getDrawable(a.e.sdk_transparent_bg));
        this.bzp.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.live.yuyinquick.QuickImInputHeaderView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                if (QuickImInputHeaderView.this.bzs != null) {
                    QuickImInputHeaderView.this.bzs.H(QuickImInputHeaderView.this.cfC.getItem(i), i);
                }
            }
        });
        findViewById(a.f.iv_more).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinquick.QuickImInputHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QuickImInputHeaderView.this.bzs != null) {
                    QuickImInputHeaderView.this.bzs.LI();
                }
            }
        });
    }

    /* loaded from: classes10.dex */
    private static class a extends BaseAdapter {
        private List<String> bzu;

        private a() {
        }

        public void setData(List<String> list) {
            if (this.bzu == null) {
                this.bzu = new ArrayList();
            }
            this.bzu.clear();
            if (list != null) {
                this.bzu.addAll(list);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.bzu != null) {
                return this.bzu.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        public String getItem(int i) {
            return (this.bzu == null || getCount() <= i) ? "" : this.bzu.get(i);
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
                bVar2.textView = (TextView) view.findViewById(a.f.f1894tv);
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

    /* loaded from: classes10.dex */
    private static class b {
        TextView textView;

        private b() {
        }
    }
}
