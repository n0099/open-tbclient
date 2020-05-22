package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class b extends g {
    private int mBreakPoint;
    private FrameLayout mBtnContainer;
    private List<a> mBtnItemList;
    private FrameLayout mContent;
    protected Context mContext;
    private View mDivider;
    private ViewGroup mView;

    /* loaded from: classes11.dex */
    public interface c {
        void onItemClick(View view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context) {
        super(context, a.i.NoTitleDialog);
        this.mBtnItemList = new ArrayList();
        this.mBreakPoint = 2;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        createView();
        aoi().ao(this.mView);
    }

    private void createView() {
        this.mContext = getContext();
        this.mView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.g.aiapps_view_hv_dialog, aoi().getCustomContentParent(), false);
        this.mContent = (FrameLayout) this.mView.findViewById(a.f.hv_content);
        this.mDivider = this.mView.findViewById(a.f.hv_divider);
        this.mBtnContainer = (FrameLayout) this.mView.findViewById(a.f.hv_btn_content);
        View createContentView = createContentView(this.mContent);
        if (createContentView != null) {
            this.mContent.addView(createContentView);
        }
        updateBackground();
        createButtonItem(this.mBtnItemList);
    }

    private void updateBackground() {
        this.mDivider.setBackgroundColor(getContext().getResources().getColor(a.c.aiapps_dialog_gray));
    }

    protected View createContentView(ViewGroup viewGroup) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBtnItemList(List<a> list) {
        this.mBtnItemList.clear();
        if (list != null) {
            this.mBtnItemList.addAll(list);
        }
    }

    private void createButtonItem(List<a> list) {
        if (list != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            if (list.size() > this.mBreakPoint) {
                linearLayout.setOrientation(1);
            } else {
                linearLayout.setOrientation(0);
            }
            for (int i = 0; i < list.size(); i++) {
                linearLayout.addView(a(list.get(i), linearLayout));
                if (i < list.size() - 1) {
                    if (list.size() > this.mBreakPoint) {
                        linearLayout.addView(createDivider(1));
                    } else {
                        linearLayout.addView(createDivider(0));
                    }
                }
            }
            this.mBtnContainer.removeAllViews();
            this.mBtnContainer.addView(linearLayout);
        }
    }

    private LinearLayout a(a aVar, LinearLayout linearLayout) {
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.aiapps_item_hv_dialog, (ViewGroup) linearLayout, false);
        linearLayout2.setBackground(getContext().getResources().getDrawable(a.e.aiapp_alertdialog_button_day_bg_all_selector));
        new d(linearLayout2, this).b(aVar);
        return linearLayout2;
    }

    private View createDivider(int i) {
        View view = new View(this.mContext);
        view.setBackgroundColor(this.mContent.getResources().getColor(a.c.aiapps_dialog_gray));
        if (i == 1) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        } else {
            view.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
        }
        return view;
    }

    /* loaded from: classes11.dex */
    public class d {
        LinearLayout button;
        b cyq;
        TextView subText;
        TextView text;

        public d(View view, b bVar) {
            if (view != null) {
                this.text = (TextView) view.findViewById(a.f.hv_btn_text);
                this.subText = (TextView) view.findViewById(a.f.hv_btn_subtext);
                this.button = (LinearLayout) view;
                this.cyq = bVar;
            }
        }

        public void b(final a aVar) {
            if (aVar != null) {
                this.text.setText(aVar.mText);
                if (aVar.mTextColorId > 0) {
                    this.text.setTextColor(b.this.mContent.getResources().getColor(aVar.mTextColorId));
                }
                if (!TextUtils.isEmpty(aVar.mSubText)) {
                    this.subText.setVisibility(0);
                    this.subText.setText(aVar.mSubText);
                } else {
                    this.subText.setVisibility(8);
                }
                if (aVar.mSubTextColorId > 0) {
                    this.subText.setTextColor(b.this.mContent.getResources().getColor(aVar.mSubTextColorId));
                }
                this.button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.b.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.cyq.dismiss();
                        if (aVar.cyp != null) {
                            aVar.cyp.onItemClick(view);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.baidu.swan.apps.res.widget.dialog.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0376b extends g.a {
        private List<a> list;

        public C0376b(Context context) {
            super(context);
            this.list = new ArrayList();
            eW(false);
            eS(false);
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        protected g bH(Context context) {
            return new b(context);
        }

        public C0376b a(a aVar) {
            if (aVar != null) {
                this.list.add(aVar);
            }
            return this;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.g.a
        public g ZF() {
            b bVar = (b) super.ZF();
            bVar.setBtnItemList(this.list);
            return bVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        public c cyp;
        public CharSequence mSubText;
        public int mSubTextColorId = -1;
        public CharSequence mText;
        public int mTextColorId;

        public a(CharSequence charSequence, int i, c cVar) {
            this.mTextColorId = -1;
            this.mText = charSequence;
            this.mTextColorId = i;
            this.cyp = cVar;
        }
    }
}
