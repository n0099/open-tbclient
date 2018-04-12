package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {
    public a FF = null;
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
        this.FF = aVar;
    }

    public int getHeadersCount() {
        return this.mHeaderViewInfos.size();
    }

    public int getFootersCount() {
        return this.mFooterViewInfos.size();
    }

    public void addHeaderView(View view2, Object obj, boolean z, int i) {
        if (view2 != null) {
            c cVar = new c();
            cVar.FH = new q.a(view2);
            cVar.data = obj;
            cVar.isSelectable = z;
            cVar.type = BdUniqueId.gen().getId();
            cVar.id = cVar.type;
            view2.setTag("HEADER");
            if (i < 0 || i > this.mHeaderViewInfos.size()) {
                this.mHeaderViewInfos.add(cVar);
            } else {
                this.mHeaderViewInfos.add(i, cVar);
            }
        }
    }

    public void addFooterView(View view2, Object obj, boolean z, int i) {
        if (view2 != null) {
            c cVar = new c();
            cVar.FH = new q.a(view2);
            cVar.data = obj;
            cVar.isSelectable = z;
            cVar.type = BdUniqueId.gen().getId();
            cVar.id = cVar.type;
            view2.setTag("FOOTER");
            if (i < 0 || i > this.mFooterViewInfos.size()) {
                this.mFooterViewInfos.add(cVar);
            } else {
                this.mFooterViewInfos.add(i, cVar);
            }
        }
    }

    public boolean removeHeader(View view2) {
        if (view2 == null) {
            return false;
        }
        for (int i = 0; i < this.mHeaderViewInfos.size(); i++) {
            c cVar = this.mHeaderViewInfos.get(i);
            if (cVar != null && cVar.FH != null && cVar.FH.itemView == view2) {
                this.mHeaderViewInfos.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean removeFooter(View view2) {
        if (view2 == null) {
            return false;
        }
        for (int i = 0; i < this.mFooterViewInfos.size(); i++) {
            c cVar = this.mFooterViewInfos.get(i);
            if (cVar != null && cVar.FH != null && cVar.FH.itemView == view2) {
                this.mFooterViewInfos.remove(i);
                return true;
            }
        }
        return false;
    }

    public q.a aH(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mHeaderViewInfos.size()) {
                if (this.mHeaderViewInfos.get(i3) == null || i != this.mHeaderViewInfos.get(i3).type) {
                    i2 = i3 + 1;
                } else {
                    return this.mHeaderViewInfos.get(i3).FH;
                }
            } else {
                return null;
            }
        }
    }

    public q.a aI(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mFooterViewInfos.size()) {
                if (this.mFooterViewInfos.get(i3) == null || i != this.mFooterViewInfos.get(i3).type) {
                    i2 = i3 + 1;
                } else {
                    return this.mFooterViewInfos.get(i3).FH;
                }
            } else {
                return null;
            }
        }
    }

    public q.a ak(Context context) {
        TextView textView = new TextView(context);
        textView.setText(BdBaseApplication.getInst().getContext().getString(R.string.load_res_failed));
        int dip2px = com.baidu.adp.lib.util.l.dip2px(context, 15.0f);
        textView.setPadding(dip2px, dip2px, dip2px, dip2px);
        return new b(textView);
    }

    /* loaded from: classes.dex */
    class b extends q.a {
        public b(View view2) {
            super(view2);
        }
    }

    /* loaded from: classes.dex */
    public class c {
        public q.a FH;
        public Object data;
        public long id;
        public boolean isSelectable;
        public int type;

        public c() {
        }
    }
}
