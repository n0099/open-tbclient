package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.widget.ListView.v;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {
    public a Nc = null;
    public ArrayList<c> mFooterViewInfos;
    public ArrayList<c> mHeaderViewInfos;

    /* loaded from: classes.dex */
    public interface a {
        void onPreLoad();
    }

    public d() {
        this.mHeaderViewInfos = null;
        this.mFooterViewInfos = null;
        this.mHeaderViewInfos = new ArrayList<>();
        this.mFooterViewInfos = new ArrayList<>();
    }

    public void a(a aVar) {
        this.Nc = aVar;
    }

    public int oe() {
        return this.mHeaderViewInfos.size();
    }

    public int og() {
        return this.mFooterViewInfos.size();
    }

    public void addHeaderView(View view, Object obj, boolean z, int i) {
        if (view != null) {
            c cVar = new c();
            cVar.Ne = new v.a(view);
            cVar.data = obj;
            cVar.Nf = z;
            cVar.type = BdUniqueId.gen().getId();
            cVar.id = cVar.type;
            view.setTag("HEADER");
            if (i < 0 || i > this.mHeaderViewInfos.size()) {
                this.mHeaderViewInfos.add(cVar);
            } else {
                this.mHeaderViewInfos.add(i, cVar);
            }
        }
    }

    public void addFooterView(View view, Object obj, boolean z, int i) {
        if (view != null) {
            c cVar = new c();
            cVar.Ne = new v.a(view);
            cVar.data = obj;
            cVar.Nf = z;
            cVar.type = BdUniqueId.gen().getId();
            cVar.id = cVar.type;
            view.setTag("FOOTER");
            if (i < 0 || i > this.mFooterViewInfos.size()) {
                this.mFooterViewInfos.add(cVar);
            } else {
                this.mFooterViewInfos.add(i, cVar);
            }
        }
    }

    public boolean B(View view) {
        if (view == null) {
            return false;
        }
        for (int i = 0; i < this.mHeaderViewInfos.size(); i++) {
            c cVar = this.mHeaderViewInfos.get(i);
            if (cVar != null && cVar.Ne != null && cVar.Ne.itemView == view) {
                this.mHeaderViewInfos.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean C(View view) {
        if (view == null) {
            return false;
        }
        for (int i = 0; i < this.mFooterViewInfos.size(); i++) {
            c cVar = this.mFooterViewInfos.get(i);
            if (cVar != null && cVar.Ne != null && cVar.Ne.itemView == view) {
                this.mFooterViewInfos.remove(i);
                return true;
            }
        }
        return false;
    }

    public v.a aK(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHeaderViewInfos.size()) {
                if (this.mHeaderViewInfos.get(i3) == null || i != this.mHeaderViewInfos.get(i3).type) {
                    i2 = i3 + 1;
                } else {
                    return this.mHeaderViewInfos.get(i3).Ne;
                }
            } else {
                return null;
            }
        }
    }

    public v.a aL(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mFooterViewInfos.size()) {
                if (this.mFooterViewInfos.get(i3) == null || i != this.mFooterViewInfos.get(i3).type) {
                    i2 = i3 + 1;
                } else {
                    return this.mFooterViewInfos.get(i3).Ne;
                }
            } else {
                return null;
            }
        }
    }

    public v.a ak(Context context) {
        TextView textView = new TextView(context);
        textView.setText(BdBaseApplication.getInst().getContext().getString(R.string.load_res_failed));
        int dip2px = com.baidu.adp.lib.util.l.dip2px(context, 15.0f);
        textView.setPadding(dip2px, dip2px, dip2px, dip2px);
        textView.setHeight(0);
        return new b(textView);
    }

    /* loaded from: classes.dex */
    class b extends v.a {
        public b(View view) {
            super(view);
        }
    }

    /* loaded from: classes.dex */
    public class c {
        public v.a Ne;
        public boolean Nf;
        public Object data;
        public long id;
        public int type;

        public c() {
        }
    }
}
