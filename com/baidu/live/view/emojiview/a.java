package com.baidu.live.view.emojiview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
/* loaded from: classes10.dex */
public class a implements AdapterView.OnItemClickListener {
    private static b bQW;
    private static b bQX;
    private String[] bQY;
    private String[] bQZ;
    private View bRa;
    private Context mContext;

    /* loaded from: classes10.dex */
    public interface b {
        void al(View view);

        void hR(String str);
    }

    public static a b(Context context, String[] strArr) {
        return new a(context, strArr);
    }

    public a(Context context, String[] strArr) {
        this.bQY = strArr;
        this.mContext = context;
    }

    public GridView Wf() {
        this.bRa = LayoutInflater.from(this.mContext).inflate(a.g.bd_im_emojicon_grid, (ViewGroup) null);
        GridView gridView = (GridView) this.bRa.findViewById(a.f.Emoji_GridView);
        this.bQZ = new String[this.bQY.length + 1];
        for (int i = 0; i < this.bQY.length; i++) {
            this.bQZ[i] = this.bQY[i];
        }
        c(gridView);
        gridView.setAdapter((ListAdapter) new C0228a(this.mContext, this.bQZ));
        gridView.setOnItemClickListener(this);
        return gridView;
    }

    private void c(GridView gridView) {
        int keyboardHeight = TbadkCoreApplication.getInst().getKeyboardHeight();
        int i = keyboardHeight < 100 ? SharedPrefHelper.getInstance().getInt("audio_live_keyboard_height", keyboardHeight) : keyboardHeight;
        if (i > 100) {
            SharedPrefHelper.getInstance().putInt("audio_live_keyboard_height", i);
            int dimension = (int) this.mContext.getResources().getDimension(a.d.bd_im_emoji_bar_height);
            int dimension2 = ((int) this.mContext.getResources().getDimension(a.d.bd_im_emoji_pager_dot_height)) * 4;
            int dimension3 = ((int) this.mContext.getResources().getDimension(a.d.bd_im_emoji_row_height)) * 3;
            int dimension4 = (int) this.mContext.getResources().getDimension(a.d.bd_im_emoji_row_max_space);
            int i2 = (((i - dimension) - dimension2) - dimension3) / 2;
            if (i2 <= 0) {
                i2 = 0;
            }
            if (i2 <= dimension4) {
                dimension4 = i2;
            }
            gridView.setVerticalSpacing(dimension4);
        }
    }

    public static void a(b bVar) {
        if (bVar instanceof b) {
            bQX = bVar;
            bQW = bVar;
            return;
        }
        throw new IllegalArgumentException(bVar + " must implement interface " + b.class.getSimpleName());
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (bQW != null) {
            if (i != this.bQZ.length - 1) {
                bQW.hR((String) adapterView.getItemAtPosition(i));
                return;
            } else {
                bQW.al(view);
                return;
            }
        }
        bQW = bQX;
    }

    /* renamed from: com.baidu.live.view.emojiview.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class C0228a extends ArrayAdapter<String> {
        public C0228a(Context context, String[] strArr) {
            super(context, a.g.sdk_bd_im_emojicon_item, strArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(getContext(), a.g.sdk_bd_im_emojicon_item, null);
                C0229a c0229a = new C0229a();
                c0229a.bRc = (EmojiconTextView) view.findViewById(a.f.emojicon_icon);
                view.setTag(c0229a);
            }
            if (i == getCount() - 1) {
                return View.inflate(getContext(), a.g.bd_im_emojicon_backspace, null);
            }
            String item = getItem(i);
            C0229a c0229a2 = (C0229a) view.getTag();
            if (c0229a2 != null && c0229a2.bRc != null && item != null) {
                c0229a2.bRc.setText(item);
                return view;
            }
            return view;
        }

        /* renamed from: com.baidu.live.view.emojiview.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        class C0229a {
            EmojiconTextView bRc;

            C0229a() {
            }
        }
    }
}
