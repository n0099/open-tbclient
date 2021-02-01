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
import java.util.List;
/* loaded from: classes11.dex */
public class a implements AdapterView.OnItemClickListener {
    private static b bUM;
    private static b bUN;
    private String[] bUO;
    private View bUP;
    private Context mContext;
    private List<String> mData;

    /* loaded from: classes11.dex */
    public interface b {
        void aj(View view);

        void im(String str);
    }

    public static a c(Context context, List<String> list) {
        return new a(context, list);
    }

    public a(Context context, List<String> list) {
        this.mData = list;
        this.mContext = context;
    }

    public GridView XO() {
        this.bUP = LayoutInflater.from(this.mContext).inflate(a.g.bd_im_emojicon_grid, (ViewGroup) null);
        GridView gridView = (GridView) this.bUP.findViewById(a.f.Emoji_GridView);
        this.bUO = new String[this.mData.size() + 1];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mData.size()) {
                this.bUO[i2] = this.mData.get(i2);
                i = i2 + 1;
            } else {
                c(gridView);
                gridView.setAdapter((ListAdapter) new C0230a(this.mContext, this.bUO));
                gridView.setOnItemClickListener(this);
                return gridView;
            }
        }
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
            bUN = bVar;
            bUM = bVar;
            return;
        }
        throw new IllegalArgumentException(bVar + " must implement interface " + b.class.getSimpleName());
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (bUM != null) {
            if (i != this.bUO.length - 1) {
                bUM.im((String) adapterView.getItemAtPosition(i));
                return;
            } else {
                bUM.aj(view);
                return;
            }
        }
        bUM = bUN;
    }

    /* renamed from: com.baidu.live.view.emojiview.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class C0230a extends ArrayAdapter<String> {
        public C0230a(Context context, String[] strArr) {
            super(context, a.g.sdk_bd_im_emojicon_item, strArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(getContext(), a.g.sdk_bd_im_emojicon_item, null);
                C0231a c0231a = new C0231a();
                c0231a.bUR = (EmojiconTextView) view.findViewById(a.f.emojicon_icon);
                view.setTag(c0231a);
            }
            if (i == getCount() - 1) {
                return View.inflate(getContext(), a.g.bd_im_emojicon_backspace, null);
            }
            String item = getItem(i);
            C0231a c0231a2 = (C0231a) view.getTag();
            if (c0231a2 != null && c0231a2.bUR != null && item != null) {
                c0231a2.bUR.setText(item);
                return view;
            }
            return view;
        }

        /* renamed from: com.baidu.live.view.emojiview.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        class C0231a {
            EmojiconTextView bUR;

            C0231a() {
            }
        }
    }
}
