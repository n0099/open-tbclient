package com.baidu.searchbox.player.callback;

import com.baidu.searchbox.player.widget.BdThumbSeekBarView;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/player/callback/ISeekBarListener;", "", "onProgressChanged", "", "seekBar", "Lcom/baidu/searchbox/player/widget/BdThumbSeekBarView;", "progress", "", "fromUser", "", "onProgressForward", "onStartTrackingTouch", "onStopTrackingTouch", "framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ISeekBarListener {
    void onProgressChanged(BdThumbSeekBarView bdThumbSeekBarView, int i, boolean z);

    void onProgressForward();

    void onStartTrackingTouch(BdThumbSeekBarView bdThumbSeekBarView);

    void onStopTrackingTouch(BdThumbSeekBarView bdThumbSeekBarView);
}
