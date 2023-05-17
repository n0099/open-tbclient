package com.baidu.searchbox.unitedscheme;
/* loaded from: classes4.dex */
public interface IExternalTransferIoc {
    public static final IExternalTransferIoc EMPTY = new IExternalTransferIoc() { // from class: com.baidu.searchbox.unitedscheme.IExternalTransferIoc.1
        @Override // com.baidu.searchbox.unitedscheme.IExternalTransferIoc
        public void addEvent(String str) {
        }

        @Override // com.baidu.searchbox.unitedscheme.IExternalTransferIoc
        public void addEvent(String str, String str2) {
        }
    };

    void addEvent(String str);

    void addEvent(String str, String str2);
}
