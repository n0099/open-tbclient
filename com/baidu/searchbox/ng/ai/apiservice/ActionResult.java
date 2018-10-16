package com.baidu.searchbox.ng.ai.apiservice;
/* loaded from: classes2.dex */
public class ActionResult {
    public final boolean isSuccess;
    public final String msg;
    public final int msgCode;
    public final Object result;

    private ActionResult(Builder builder) {
        this.isSuccess = builder.isSuccess;
        this.msg = builder.msg;
        this.msgCode = builder.msgCode;
        this.result = builder.result;
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        private boolean isSuccess;
        private String msg;
        private int msgCode;
        private Object result;

        public Builder success(boolean z) {
            this.isSuccess = z;
            return this;
        }

        public Builder msgCode(int i) {
            this.msgCode = i;
            return this;
        }

        public Builder msg(String str) {
            this.msg = str;
            return this;
        }

        public Builder result(Object obj) {
            this.result = obj;
            return this;
        }

        public ActionResult build() {
            return new ActionResult(this);
        }
    }
}
