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
/* loaded from: classes11.dex */
public class a extends RecyclerView.Adapter<C0352a> {
    private List<InvoiceInfo> cCU = new ArrayList();
    private b cDT;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public interface b {
        void a(View view, InvoiceInfo invoiceInfo);

        void b(View view, InvoiceInfo invoiceInfo);

        void c(View view, InvoiceInfo invoiceInfo);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void ak(List<InvoiceInfo> list) {
        int arb;
        if (list != null && list.size() > 0) {
            this.cCU.clear();
            this.cCU.addAll(list);
            if (this.cCU.get(0).mIsDefault != 1 && (arb = arb()) >= 0) {
                a(this.cCU.get(arb), false);
            }
            notifyDataSetChanged();
        }
    }

    public void bt(long j) {
        if (this.cCU != null && this.cCU.size() > 0) {
            for (int i = 0; i < this.cCU.size(); i++) {
                InvoiceInfo invoiceInfo = this.cCU.get(i);
                if (invoiceInfo != null && invoiceInfo.mId == j) {
                    this.cCU.remove(i);
                    notifyItemRemoved(i);
                    if (i != this.cCU.size()) {
                        notifyItemRangeChanged(0, this.cCU.size());
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void m(InvoiceInfo invoiceInfo) {
        if (this.cCU != null && invoiceInfo != null) {
            this.cCU.add(0, invoiceInfo);
            notifyItemInserted(0);
        }
    }

    public void bu(long j) {
        int bv;
        if (this.cCU != null && (bv = bv(j)) >= 0) {
            int arb = arb();
            if (arb >= 0) {
                this.cCU.get(arb).mIsDefault = 0;
                notifyItemChanged(arb);
            }
            this.cCU.get(bv).mIsDefault = 1;
            notifyItemChanged(bv);
        }
    }

    public void n(InvoiceInfo invoiceInfo) {
        int bv;
        if (this.cCU != null && (bv = bv(invoiceInfo.mId)) >= 0) {
            this.cCU.set(bv, invoiceInfo);
            notifyItemChanged(bv);
            a(invoiceInfo, true);
        }
    }

    public void a(InvoiceInfo invoiceInfo, boolean z) {
        if (this.cCU != null && this.cCU.size() > 1 && invoiceInfo != null) {
            for (int i = 0; i < this.cCU.size(); i++) {
                InvoiceInfo invoiceInfo2 = this.cCU.get(i);
                if (invoiceInfo2 != null && invoiceInfo2.equals(invoiceInfo)) {
                    this.cCU.remove(i);
                    this.cCU.add(0, invoiceInfo2);
                    if (z) {
                        notifyItemMoved(i, 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private int arb() {
        if (this.cCU == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cCU.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.cCU.get(i2);
            if (invoiceInfo == null || invoiceInfo.mIsDefault != 1) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    private int bv(long j) {
        if (this.cCU == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cCU.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.cCU.get(i2);
            if (invoiceInfo == null || invoiceInfo.mId != j) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public void a(b bVar) {
        this.cDT = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: d */
    public C0352a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0352a c0352a = new C0352a(LayoutInflater.from(this.mContext).inflate(b.f.invoice_list_item_view, viewGroup, false));
        if (i == 0) {
            c0352a.cDV.arc();
        } else if (i == 1) {
            c0352a.cDV.ard();
        }
        return c0352a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0352a c0352a, int i) {
        final InvoiceInfo invoiceInfo = this.cCU.get(i);
        if (invoiceInfo != null) {
            if (c0352a.getItemViewType() == 0) {
                c0352a.cDV.setCompanyInfo(invoiceInfo.mTitle, invoiceInfo.mTaxNumber);
            } else if (c0352a.getItemViewType() == 1) {
                c0352a.cDV.setPersonageInfo(invoiceInfo.mTitle);
            }
            if (invoiceInfo.mIsDefault == 1) {
                c0352a.cDV.fq(true);
            } else {
                c0352a.cDV.fq(false);
            }
            c0352a.cDV.setEditClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.cDT != null) {
                        a.this.cDT.b(view, invoiceInfo);
                    }
                }
            });
            c0352a.cDV.setItemClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.cDT != null) {
                        a.this.cDT.a(view, invoiceInfo);
                    }
                }
            });
            c0352a.cDV.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.a.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (a.this.cDT != null) {
                        a.this.cDT.c(view, invoiceInfo);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.cCU != null) {
            return this.cCU.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.cCU != null) {
            InvoiceInfo invoiceInfo = this.cCU.get(i);
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
    /* loaded from: classes11.dex */
    public class C0352a extends RecyclerView.ViewHolder {
        InvoiceListItemView cDV;

        public C0352a(View view) {
            super(view);
            this.cDV = (InvoiceListItemView) view.findViewById(b.e.invoice_list_item);
        }
    }
}
