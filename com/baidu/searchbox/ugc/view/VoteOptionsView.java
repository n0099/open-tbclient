package com.baidu.searchbox.ugc.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.ugc.model.UgcVoteInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class VoteOptionsView extends LinearLayout implements View.OnClickListener {
    private static final int VOTE_ITEM_LEFT_MARGIN = 10;
    private static final String VOTE_OPTION_IS_CHECKED = "1";
    private static final String VOTE_OPTION_NOT_CHECKED = "0";
    private List<VoteOptionsItemView> mListItem;
    private List<UgcVoteInfo.VoteOption> mOptions;

    public VoteOptionsView(Context context) {
        super(context);
        this.mListItem = new ArrayList();
        this.mOptions = new ArrayList();
        init(context);
    }

    public VoteOptionsView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mListItem = new ArrayList();
        this.mOptions = new ArrayList();
        init(context);
    }

    public VoteOptionsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mListItem = new ArrayList();
        this.mOptions = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        setOrientation(0);
    }

    public List<UgcVoteInfo.VoteOption> getOptions() {
        return this.mOptions;
    }

    public void initLayout(UgcVoteInfo ugcVoteInfo) {
        removeAllViews();
        if (ugcVoteInfo != null && ugcVoteInfo.voteOptions.size() > 0) {
            this.mOptions = ugcVoteInfo.voteOptions;
            int size = ugcVoteInfo.voteOptions.size();
            LinearLayout linearLayout = new LinearLayout(getContext());
            addView(linearLayout, new LinearLayout.LayoutParams(-2, -2));
            for (int i = 0; i < size; i++) {
                UgcVoteInfo.VoteOption voteOption = this.mOptions.get(i);
                if (voteOption != null) {
                    VoteOptionsItemView createItem = createItem(voteOption);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    if (i != 0) {
                        layoutParams.setMargins(DeviceUtil.ScreenInfo.dp2px(getContext(), 10.0f), 0, 0, 0);
                    }
                    linearLayout.addView(createItem, layoutParams);
                    this.mListItem.add(createItem);
                }
            }
        }
    }

    private VoteOptionsItemView createItem(UgcVoteInfo.VoteOption voteOption) {
        VoteOptionsItemView voteOptionsItemView = new VoteOptionsItemView(getContext());
        if ("1".equals(voteOption.voteTagState)) {
            voteOptionsItemView.setVoteItemForIsChecked(voteOption.voteTagName, voteOption.voteValue);
        } else {
            voteOptionsItemView.setVoteItemDefault(voteOption.voteTagName);
        }
        voteOptionsItemView.setOnClickListener(this);
        return voteOptionsItemView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mOptions.size()) {
                if (view == this.mListItem.get(i2)) {
                    if (TextUtils.equals("1", this.mOptions.get(i2).voteTagState)) {
                        this.mListItem.get(i2).setVoteItemDefault(this.mOptions.get(i2).voteTagName);
                        this.mOptions.get(i2).voteTagState = "0";
                    } else {
                        this.mListItem.get(i2).setVoteItemForIsChecked(this.mOptions.get(i2).voteTagName, this.mOptions.get(i2).voteValue);
                        this.mOptions.get(i2).voteTagState = "1";
                    }
                } else {
                    this.mListItem.get(i2).setVoteItemDefault(this.mOptions.get(i2).voteTagName);
                    this.mOptions.get(i2).voteTagState = "0";
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
