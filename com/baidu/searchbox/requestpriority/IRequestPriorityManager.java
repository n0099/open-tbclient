package com.baidu.searchbox.requestpriority;
/* loaded from: classes2.dex */
public interface IRequestPriorityManager {
    public static final IRequestPriorityManager EMPTY = new IRequestPriorityManager() { // from class: com.baidu.searchbox.requestpriority.IRequestPriorityManager.1
        @Override // com.baidu.searchbox.requestpriority.IRequestPriorityManager
        public RequestPriorityParams getRequestPriorityParams() {
            return null;
        }
    };

    RequestPriorityParams getRequestPriorityParams();
}
