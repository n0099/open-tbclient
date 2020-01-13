package com.baidu.searchbox.ugc.emoji;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.utils.ResourceUtils;
/* loaded from: classes12.dex */
public class EmojiAdapter extends ArrayAdapter<Emojicon> {
    public EmojiAdapter(Context context, Emojicon[] emojiconArr) {
        super(context, R.layout.ugc_bd_im_emojicon_item, emojiconArr);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = View.inflate(getContext(), R.layout.ugc_bd_im_emojicon_item, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.icon = (TextView) view.findViewById(ResourceUtils.getResIdByName("emojicon_icon"));
            view.setTag(viewHolder);
        }
        if (i == getCount() - 1) {
            return View.inflate(getContext(), R.layout.ugc_bd_im_emojicon_backspace, null);
        }
        Emojicon item = getItem(i);
        ViewHolder viewHolder2 = (ViewHolder) view.getTag();
        if (viewHolder2 != null && viewHolder2.icon != null && item != null) {
            viewHolder2.icon.setText(item.getEmoji());
            return view;
        }
        return view;
    }

    /* loaded from: classes12.dex */
    class ViewHolder {
        TextView icon;

        ViewHolder() {
        }
    }
}
