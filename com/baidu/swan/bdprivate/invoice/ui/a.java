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
/* loaded from: classes10.dex */
public class a extends RecyclerView.Adapter<C0312a> {
    private List<InvoiceInfo> bZD = new ArrayList();
    private b caC;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public interface b {
        void a(View view, InvoiceInfo invoiceInfo);

        void b(View view, InvoiceInfo invoiceInfo);

        void c(View view, InvoiceInfo invoiceInfo);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void ac(List<InvoiceInfo> list) {
        int agA;
        if (list != null && list.size() > 0) {
            this.bZD.clear();
            this.bZD.addAll(list);
            if (this.bZD.get(0).mIsDefault != 1 && (agA = agA()) >= 0) {
                a(this.bZD.get(agA), false);
            }
            notifyDataSetChanged();
        }
    }

    public void aK(long j) {
        if (this.bZD != null && this.bZD.size() > 0) {
            for (int i = 0; i < this.bZD.size(); i++) {
                InvoiceInfo invoiceInfo = this.bZD.get(i);
                if (invoiceInfo != null && invoiceInfo.mId == j) {
                    this.bZD.remove(i);
                    notifyItemRemoved(i);
                    if (i != this.bZD.size()) {
                        notifyItemRangeChanged(0, this.bZD.size());
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void m(InvoiceInfo invoiceInfo) {
        if (this.bZD != null && invoiceInfo != null) {
            this.bZD.add(0, invoiceInfo);
            notifyItemInserted(0);
        }
    }

    public void aL(long j) {
        int aM;
        if (this.bZD != null && (aM = aM(j)) >= 0) {
            int agA = agA();
            if (agA >= 0) {
                this.bZD.get(agA).mIsDefault = 0;
                notifyItemChanged(agA);
            }
            this.bZD.get(aM).mIsDefault = 1;
            notifyItemChanged(aM);
        }
    }

    public void n(InvoiceInfo invoiceInfo) {
        int aM;
        if (this.bZD != null && (aM = aM(invoiceInfo.mId)) >= 0) {
            this.bZD.set(aM, invoiceInfo);
            notifyItemChanged(aM);
            a(invoiceInfo, true);
        }
    }

    public void a(InvoiceInfo invoiceInfo, boolean z) {
        if (this.bZD != null && this.bZD.size() > 1 && invoiceInfo != null) {
            for (int i = 0; i < this.bZD.size(); i++) {
                InvoiceInfo invoiceInfo2 = this.bZD.get(i);
                if (invoiceInfo2 != null && invoiceInfo2.equals(invoiceInfo)) {
                    this.bZD.remove(i);
                    this.bZD.add(0, invoiceInfo2);
                    if (z) {
                        notifyItemMoved(i, 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private int agA() {
        if (this.bZD == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bZD.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.bZD.get(i2);
            if (invoiceInfo == null || invoiceInfo.mIsDefault != 1) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    private int aM(long j) {
        if (this.bZD == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bZD.size()) {
                return -1;
            }
            InvoiceInfo invoiceInfo = this.bZD.get(i2);
            if (invoiceInfo == null || invoiceInfo.mId != j) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    public void a(b bVar) {
        this.caC = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: d */
    public C0312a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0312a c0312a = new C0312a(LayoutInflater.from(this.mContext).inflate(b.f.invoice_list_item_view, viewGroup, false));
        if (i == 0) {
            c0312a.caE.agB();
        } else if (i == 1) {
            c0312a.caE.agC();
        }
        return c0312a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(C0312a c0312a, int i) {
        final InvoiceInfo invoiceInfo = this.bZD.get(i);
        if (invoiceInfo != null) {
            if (c0312a.getItemViewType() == 0) {
                c0312a.caE.setCompanyInfo(invoiceInfo.mTitle, invoiceInfo.mTaxNumber);
            } else if (c0312a.getItemViewType() == 1) {
                c0312a.caE.setPersonageInfo(invoiceInfo.mTitle);
            }
            if (invoiceInfo.mIsDefault == 1) {
                c0312a.caE.el(true);
            } else {
                c0312a.caE.el(false);
            }
            c0312a.caE.setEditClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.caC != null) {
                        a.this.caC.b(view, invoiceInfo);
                    }
                }
            });
            c0312a.caE.setItemClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.caC != null) {
                        a.this.caC.a(view, invoiceInfo);
                    }
                }
            });
            c0312a.caE.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.a.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (a.this.caC != null) {
                        a.this.caC.c(view, invoiceInfo);
                        return true;
                    }
                    return true;
                }
            });
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.bZD != null) {
            return this.bZD.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.bZD != null) {
            InvoiceInfo invoiceInfo = this.bZD.get(i);
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
    /* loaded from: classes10.dex */
    public class C0312a extends RecyclerView.ViewHolder {
        InvoiceListItemView caE;

        public C0312a(View view) {
            super(view);
            this.caE = (InvoiceListItemView) view.findViewById(b.e.invoice_list_item);
        }
    }
}
