package com.baidu.searchbox.ugc.presenter;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.activity.ForwardPublishActivity;
import com.baidu.searchbox.ugc.activity.IPublishView;
import com.baidu.searchbox.ugc.emoji.EmojiconEditText;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.searchbox.ugc.webjs.UgcSchemeModel;
import com.baidu.spswitch.b.a;
import com.baidu.spswitch.emotion.EmotionType;
import com.baidu.spswitch.emotion.c;
import com.baidu.spswitch.view.SPSwitchPanelLinearLayout;
/* loaded from: classes12.dex */
public class PluginVideoPublishPresenter extends VideoBasePublishPresenter {
    public PluginVideoPublishPresenter(IPublishView iPublishView) {
        super(iPublishView);
        this.mNumberTvColor = R.color.ugc_white_transparency_40;
        this.mEnableClick = true;
    }

    @Override // com.baidu.searchbox.ugc.presenter.VideoBasePublishPresenter
    protected void showPublishStart() {
    }

    @Override // com.baidu.searchbox.ugc.presenter.VideoBasePublishPresenter, com.baidu.searchbox.ugc.presenter.BasePublishPresenter
    public void onCreate(UgcSchemeModel ugcSchemeModel) {
        super.onCreate(ugcSchemeModel);
        this.mKeyboardDrawable = R.drawable.ugc_panel_keyboard_unpress;
        this.mEmojiDrawable = R.drawable.ugc_panel_emoji_unpress;
    }

    @Override // com.baidu.searchbox.ugc.presenter.BasePublishPresenter
    protected void loadInnerEmotionPanel(SPSwitchPanelLinearLayout sPSwitchPanelLinearLayout, EmojiconEditText emojiconEditText) {
        c.bb(this.mPublishView.getContext().getApplicationContext()).a(new a.InterfaceC0184a() { // from class: com.baidu.searchbox.ugc.presenter.PluginVideoPublishPresenter.1
            @Override // com.baidu.spswitch.b.a.InterfaceC0184a
            public void onEmotionClick(EmotionType emotionType, int i, String str, String str2) {
                if (!TextUtils.isEmpty(str)) {
                    UgcUBCUtils.emotionUbcStatistics(PluginVideoPublishPresenter.this.mSourceFrom, PluginVideoPublishPresenter.this.mPublishView.getContext() instanceof ForwardPublishActivity, str);
                }
            }
        });
        c.bb(this.mPublishView.getContext().getApplicationContext()).a(emojiconEditText);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ugc.presenter.BasePublishPresenter
    public void switchToPanel(View view, boolean z) {
        super.switchToPanel(view, z);
        if (view != null) {
            if (z) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.searchbox.ugc.presenter.BasePublishPresenter
    public void setClickState(TextView textView, boolean z) {
        this.mEnableClick = z;
        if (textView != null) {
            textView.setAlpha(this.mEnableClick ? 1.0f : 0.2f);
        }
    }

    @Override // com.baidu.searchbox.ugc.presenter.VideoBasePublishPresenter
    protected boolean canPublish(int i, String str) {
        return !this.mUploadding && i <= getDynamicWordLimit(this.mVideoPath);
    }

    @Override // com.baidu.searchbox.ugc.presenter.BasePublishPresenter
    public int getDynamicWordLimit(String str) {
        return this.inputVideoLimit;
    }

    @Override // com.baidu.searchbox.ugc.presenter.BasePublishPresenter
    protected void onSelectAtOrTopic() {
        if (!this.mIsShowSoftInput && !this.mPublishView.isEmojiShown()) {
            this.mIsShowSoftInput = true;
        }
    }
}
