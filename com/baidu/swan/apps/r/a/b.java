package com.baidu.swan.apps.r.a;

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
/* loaded from: classes2.dex */
public class b extends PopupWindow {
    private int axH;
    private SwanAppActivity axb;
    private String[] ayc;
    private a ayf;
    private EditText mEditText;

    /* loaded from: classes2.dex */
    public interface a {
        void DT();

        void cy(int i);
    }

    public b(@NonNull SwanAppActivity swanAppActivity, @NonNull EditText editText, int i, int i2) {
        super(swanAppActivity);
        this.ayc = new String[12];
        cz(i);
        a(swanAppActivity, editText, i2);
    }

    private void cz(int i) {
        for (int i2 = 0; i2 < 9; i2++) {
            this.ayc[i2] = String.valueOf(i2 + 1);
        }
        if (i == 1) {
            this.ayc[9] = "X";
        } else if (i == 0) {
            this.ayc[9] = "";
        } else if (i == 2) {
            this.ayc[9] = ".";
        }
        this.ayc[10] = "0";
    }

    private void a(@NonNull SwanAppActivity swanAppActivity, @NonNull EditText editText, final int i) {
        this.axb = swanAppActivity;
        this.mEditText = editText;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(swanAppActivity).inflate(a.g.aiapps_keyboard_layout, (ViewGroup) null);
        this.axH = swanAppActivity.getResources().getDimensionPixelOffset(a.d.aiapps_keyboard_total_height);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        GridView gridView = (GridView) linearLayout.findViewById(a.f.keyboard_grid_view);
        gridView.setAdapter((ListAdapter) new com.baidu.swan.apps.r.a.a(swanAppActivity, this.ayc));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.r.a.b.1
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
                } else if (text.length() < i) {
                    text.insert(selectionStart, b.this.ayc[i2]);
                    b.this.mEditText.setText(text);
                    b.this.mEditText.setSelection(selectionStart + b.this.ayc[i2].length());
                }
            }
        });
        ImageView imageView = (ImageView) linearLayout.findViewById(a.f.close_btn);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.r.a.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.dismiss();
                b.this.mEditText.clearFocus();
            }
        });
        imageView.setClickable(true);
        setContentView(linearLayout);
        setWidth(-1);
        setHeight(this.axH);
        setBackgroundDrawable(new BitmapDrawable());
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        if (this.ayf != null) {
            this.ayf.DT();
        }
    }

    public void show() {
        if (!isShowing()) {
            showAtLocation(this.axb.getWindow().getDecorView(), 80, 0, 0);
            if (this.ayf != null) {
                this.ayf.cy(this.axH);
            }
        }
    }

    public void a(@NonNull a aVar) {
        this.ayf = aVar;
    }
}
