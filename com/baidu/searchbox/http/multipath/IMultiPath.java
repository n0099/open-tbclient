package com.baidu.searchbox.http.multipath;

import java.util.List;
/* loaded from: classes4.dex */
public interface IMultiPath {
    public static final IMultiPath EMPTY = new IMultiPath() { // from class: com.baidu.searchbox.http.multipath.IMultiPath.1
        @Override // com.baidu.searchbox.http.multipath.IMultiPath
        public void addBindMobileRequestFrom(int i) {
        }

        @Override // com.baidu.searchbox.http.multipath.IMultiPath
        public List<Integer> getBindMobileFromList() {
            return null;
        }

        @Override // com.baidu.searchbox.http.multipath.IMultiPath
        public boolean isBindMobileEnabled() {
            return false;
        }

        @Override // com.baidu.searchbox.http.multipath.IMultiPath
        public boolean isBindMobileSwitchShow() {
            return false;
        }

        @Override // com.baidu.searchbox.http.multipath.IMultiPath
        public void showBindMobileToast(String str, String str2) {
        }
    };

    void addBindMobileRequestFrom(int i);

    List<Integer> getBindMobileFromList();

    boolean isBindMobileEnabled();

    boolean isBindMobileSwitchShow();

    void showBindMobileToast(String str, String str2);
}
