package com.baidu.searchbox.player.callback;

import com.baidu.searchbox.player.widget.BdThumbSeekBarView;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000f\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/player/callback/ISeekBarListener;", "Lkotlin/Any;", "Lcom/baidu/searchbox/player/widget/BdThumbSeekBarView;", "seekBar", "", "progress", "", "fromUser", "", "onProgressChanged", "(Lcom/baidu/searchbox/player/widget/BdThumbSeekBarView;IZ)V", "onProgressForward", "()V", "onStartTrackingTouch", "(Lcom/baidu/searchbox/player/widget/BdThumbSeekBarView;)V", "onStopTrackingTouch", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface ISeekBarListener {
    void onProgressChanged(BdThumbSeekBarView bdThumbSeekBarView, int i, boolean z);

    void onProgressForward();

    void onStartTrackingTouch(BdThumbSeekBarView bdThumbSeekBarView);

    void onStopTrackingTouch(BdThumbSeekBarView bdThumbSeekBarView);
}
