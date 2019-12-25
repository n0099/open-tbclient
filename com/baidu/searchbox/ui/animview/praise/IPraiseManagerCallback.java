package com.baidu.searchbox.ui.animview.praise;
/* loaded from: classes11.dex */
public interface IPraiseManagerCallback {
    int getAnchorHeight();

    int getAnchorLeft();

    int getAnchorTop();

    int getAnchorWidth();

    String getPraiseId();

    String getPraiseSource();

    /* loaded from: classes11.dex */
    public static class DefaultStub implements IPraiseManagerCallback {
        @Override // com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback
        public int getAnchorLeft() {
            return -1;
        }

        @Override // com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback
        public int getAnchorTop() {
            return -1;
        }

        @Override // com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback
        public int getAnchorWidth() {
            return -1;
        }

        @Override // com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback
        public int getAnchorHeight() {
            return -1;
        }

        @Override // com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback
        public String getPraiseSource() {
            return "";
        }

        @Override // com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback
        public String getPraiseId() {
            return "";
        }
    }
}
