package com.baidu.swan.apps.q.a;

import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.aj;
/* loaded from: classes11.dex */
public class b extends PopupWindow {
    private SwanAppActivity bUR;
    private int bUU;
    private a ckV;
    private String[] ckp;
    private EditText mEditText;

    /* loaded from: classes11.dex */
    public interface a {
        void Wy();

        void eH(int i);
    }

    public b(@NonNull SwanAppActivity swanAppActivity, @NonNull EditText editText, int i, int i2) {
        super(swanAppActivity);
        this.ckp = new String[12];
        fC(i);
        a(swanAppActivity, editText, i2);
    }

    private void fC(int i) {
        for (int i2 = 0; i2 < 9; i2++) {
            this.ckp[i2] = String.valueOf(i2 + 1);
        }
        if (i == 1) {
            this.ckp[9] = "X";
        } else if (i == 0) {
            this.ckp[9] = "";
        } else if (i == 2) {
            this.ckp[9] = ".";
        }
        this.ckp[10] = "0";
    }

    private void a(@NonNull SwanAppActivity swanAppActivity, @NonNull EditText editText, final int i) {
        this.bUR = swanAppActivity;
        this.mEditText = editText;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(swanAppActivity).inflate(a.g.aiapps_keyboard_layout, (ViewGroup) null);
        this.bUU = swanAppActivity.getResources().getDimensionPixelOffset(a.d.aiapps_keyboard_total_height);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        final GridView gridView = (GridView) linearLayout.findViewById(a.f.keyboard_grid_view);
        gridView.setAdapter((ListAdapter) new com.baidu.swan.apps.q.a.a(swanAppActivity, this.ckp));
        final AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.q.a.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                int selectionStart = b.this.mEditText.getSelectionStart();
                Editable text = b.this.mEditText.getText();
                if (i2 == 11) {
                    if (selectionStart > 0 && text != null && text.length() > 0) {
                        text.delete(selectionStart - 1, selectionStart);
                        b.this.mEditText.setText(text);
                        b.this.mEditText.setSelection(selectionStart - 1);
                    }
                } else if (text.length() < i || i < 0) {
                    text.insert(selectionStart, b.this.ckp[i2]);
                    b.this.mEditText.setText(text);
                    b.this.mEditText.setSelection(selectionStart + b.this.ckp[i2].length());
                }
            }
        };
        aj.p(new Runnable() { // from class: com.baidu.swan.apps.q.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                int childCount = gridView.getChildCount();
                if (childCount > 0) {
                    gridView.setClickable(false);
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = gridView.getChildAt(i2);
                        childAt.setTag(Integer.valueOf(i2));
                        childAt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.q.a.b.2.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                int intValue = ((Integer) view.getTag()).intValue();
                                onItemClickListener.onItemClick(gridView, view, intValue, intValue);
                            }
                        });
                    }
                    return;
                }
                gridView.setOnItemClickListener(onItemClickListener);
            }
        });
        ImageView imageView = (ImageView) linearLayout.findViewById(a.f.close_btn);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.q.a.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.dismiss();
                b.this.mEditText.clearFocus();
            }
        });
        imageView.setClickable(true);
        setContentView(linearLayout);
        setWidth(-1);
        setHeight(this.bUU);
        setBackgroundDrawable(new BitmapDrawable());
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        if (this.ckV != null) {
            this.ckV.Wy();
        }
    }

    public void show() {
        if (!isShowing()) {
            showAtLocation(this.bUR.getWindow().getDecorView(), 80, 0, 0);
            if (this.ckV != null) {
                this.ckV.eH(this.bUU);
            }
        }
    }

    public void a(@NonNull a aVar) {
        this.ckV = aVar;
    }
}
