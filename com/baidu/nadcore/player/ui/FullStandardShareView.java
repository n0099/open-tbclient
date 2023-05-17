package com.baidu.nadcore.player.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.nadcore.video.videoplayer.ui.BaseVideoPlayEndUI;
import com.baidu.nadcore.video.videoplayer.widget.ImageTextView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class FullStandardShareView extends BaseVideoPlayEndUI implements View.OnClickListener {
    public ImageTextView b;

    @Override // com.baidu.nadcore.video.videoplayer.ui.BaseVideoPlayEndUI
    public void setShowSharePanel(boolean z) {
    }

    public FullStandardShareView(Context context) {
        super(context);
    }

    @Override // com.baidu.nadcore.video.videoplayer.ui.BaseVideoPlayEndUI
    public View b(Context context) {
        ImageTextView imageTextView = new ImageTextView(context);
        this.b = imageTextView;
        imageTextView.setIconAndTitle(R.drawable.nad_videoplayer_new_player_replay_button_selector, R.string.nad_player_common_replay);
        this.b.b(R.drawable.nad_videoplayer_quick_share_item);
        this.b.setOnClickListener(this);
        return this.b;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        BaseVideoPlayEndUI.a aVar = this.a;
        if (aVar != null) {
            aVar.onItemClick(view2);
        }
    }

    public FullStandardShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FullStandardShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
