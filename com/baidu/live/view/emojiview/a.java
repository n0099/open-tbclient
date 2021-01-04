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
/* loaded from: classes11.dex */
public class a implements AdapterView.OnItemClickListener {
    private static b bVI;
    private static b bVJ;
    private String[] bVK;
    private String[] bVL;
    private View bVM;
    private Context mContext;

    /* loaded from: classes11.dex */
    public interface b {
        void al(View view);

        void jc(String str);
    }

    public static a b(Context context, String[] strArr) {
        return new a(context, strArr);
    }

    public a(Context context, String[] strArr) {
        this.bVK = strArr;
        this.mContext = context;
    }

    public GridView ZX() {
        this.bVM = LayoutInflater.from(this.mContext).inflate(a.g.bd_im_emojicon_grid, (ViewGroup) null);
        GridView gridView = (GridView) this.bVM.findViewById(a.f.Emoji_GridView);
        this.bVL = new String[this.bVK.length + 1];
        for (int i = 0; i < this.bVK.length; i++) {
            this.bVL[i] = this.bVK[i];
        }
        c(gridView);
        gridView.setAdapter((ListAdapter) new C0237a(this.mContext, this.bVL));
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
            bVJ = bVar;
            bVI = bVar;
            return;
        }
        throw new IllegalArgumentException(bVar + " must implement interface " + b.class.getSimpleName());
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (bVI != null) {
            if (i != this.bVL.length - 1) {
                bVI.jc((String) adapterView.getItemAtPosition(i));
                return;
            } else {
                bVI.al(view);
                return;
            }
        }
        bVI = bVJ;
    }

    /* renamed from: com.baidu.live.view.emojiview.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class C0237a extends ArrayAdapter<String> {
        public C0237a(Context context, String[] strArr) {
            super(context, a.g.sdk_bd_im_emojicon_item, strArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(getContext(), a.g.sdk_bd_im_emojicon_item, null);
                C0238a c0238a = new C0238a();
                c0238a.bVO = (EmojiconTextView) view.findViewById(a.f.emojicon_icon);
                view.setTag(c0238a);
            }
            if (i == getCount() - 1) {
                return View.inflate(getContext(), a.g.bd_im_emojicon_backspace, null);
            }
            String item = getItem(i);
            C0238a c0238a2 = (C0238a) view.getTag();
            if (c0238a2 != null && c0238a2.bVO != null && item != null) {
                c0238a2.bVO.setText(item);
                return view;
            }
            return view;
        }

        /* renamed from: com.baidu.live.view.emojiview.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        class C0238a {
            EmojiconTextView bVO;

            C0238a() {
            }
        }
    }
}
