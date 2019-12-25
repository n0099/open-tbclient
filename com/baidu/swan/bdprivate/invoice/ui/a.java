package com.baidu.swan.bdprivate.invoice.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.invoice.model.InvoiceInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends RecyclerView.Adapter<C0310a> {
    private List<InvoiceInfo> bZr = new ArrayList();
    private b caq;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public interface b {
        void a(View view, InvoiceInfo invoiceInfo);

        void b(View view, InvoiceInfo invoiceInfo);

        void c(View view, InvoiceInfo invoiceInfo);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void ad(List<InvoiceInfo> list) {
        int agh;
        if (list != null && list.size() > 0) {
            this.bZr.clear();
            this.bZr.addAll(list);
            if (this.bZr.get(0).mIsDefault != 1 && (agh = agh()) >= 0) {
                a(this.bZr.get(agh), false);
            }
            notifyDataSetChanged();
        }
    }

    public void aH(long j) {
        if (this.bZr != null && this.bZr.size() > 0) {
            for (int i = 0; i < this.bZr.size(); i++) {
                InvoiceInfo invoiceInfo = this.bZr.get(i);
                if (invoiceInfo != null && invoiceInfo.mId == j) {
                    this.bZr.remove(i);
                    notifyItemRemoved(i);
                    if (i != this.bZr.size()) {
                        notifyItemRangeChanged(0, this.bZr.size());
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void m(InvoiceInfo invoiceInfo) {
        if (this.bZr != null && invoiceInfo != null) {
            this.bZr.add(0, invoiceInfo);
            notifyItemInserted(0);
        }
    }

    public void aI(long j) {
        int aJ;
        if (this.bZr != null && (aJ = aJ(j)) >= 0) {
            int agh = agh();
            if (agh >= 0) {
                this.bZr.get(agh).mIsDefault = 0;
                notifyItemChanged(agh);
            }
            this.bZr.get(aJ).mIsDefault = 1;
            notifyItemChanged(aJ);
        }
    }

    public void n(InvoiceInfo invoiceInfo) {
        int aJ;
        if (this.bZr != null && (aJ = aJ(invoiceInfo.mId)) >= 0) {
            this.bZr.set(aJ, invoiceInfo);
            notifyItemChanged(aJ);
            a(invoiceInfo, true);
        }
    }

    public void a(InvoiceInfo invoiceInfo, boolean z) {
        if (this.bZr != null && this.bZr.size() > 1 && invoiceInfo != null) {
            for (int i = 0; i < this.bZr.size(); i++) {
                InvoiceInfo invoiceInfo2 = this.bZr.get(i);
                if (invoiceInfo2 != null && invoiceInfo2.equals(invoiceInfo)) {
                    this.bZr.remove(i);
                    this.bZr.add(0, invoiceInfo2);
                    if (z) {
                        notifyItemMoved(i, 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private int agh() {
        if (this.bZr == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bZr.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.bZr.get(i2);
            if (invoiceInfo == null || invoiceInfo.mIsDefault != 1) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    private int aJ(long j) {
        if (this.bZr == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bZr.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.bZr.get(i2);
            if (invoiceInfo == null || invoiceInfo.mId != j) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public void a(b bVar) {
        this.caq = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: d */
    public C0310a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0310a c0310a = new C0310a(LayoutInflater.from(this.mContext).inflate(b.f.invoice_list_item_view, viewGroup, false));
        if (i == 0) {
            c0310a.cas.agi();
        } else if (i == 1) {
            c0310a.cas.agj();
        }
        return c0310a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0310a c0310a, int i) {
        final InvoiceInfo invoiceInfo = this.bZr.get(i);
        if (invoiceInfo != null) {
            if (c0310a.getItemViewType() == 0) {
                c0310a.cas.setCompanyInfo(invoiceInfo.mTitle, invoiceInfo.mTaxNumber);
            } else if (c0310a.getItemViewType() == 1) {
                c0310a.cas.setPersonageInfo(invoiceInfo.mTitle);
            }
            if (invoiceInfo.mIsDefault == 1) {
                c0310a.cas.eg(true);
            } else {
                c0310a.cas.eg(false);
            }
            c0310a.cas.setEditClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.caq != null) {
                        a.this.caq.b(view, invoiceInfo);
                    }
                }
            });
            c0310a.cas.setItemClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.caq != null) {
                        a.this.caq.a(view, invoiceInfo);
                    }
                }
            });
            c0310a.cas.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.a.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (a.this.caq != null) {
                        a.this.caq.c(view, invoiceInfo);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.bZr != null) {
            return this.bZr.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.bZr != null) {
            InvoiceInfo invoiceInfo = this.bZr.get(i);
            if (invoiceInfo != null && invoiceInfo.mType == 0) {
                return 0;
            }
            if (invoiceInfo != null && invoiceInfo.mType == 1) {
                return 1;
            }
        }
        return super.getItemViewType(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.bdprivate.invoice.ui.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0310a extends RecyclerView.ViewHolder {
        InvoiceListItemView cas;

        public C0310a(View view) {
            super(view);
            this.cas = (InvoiceListItemView) view.findViewById(b.e.invoice_list_item);
        }
    }
}
