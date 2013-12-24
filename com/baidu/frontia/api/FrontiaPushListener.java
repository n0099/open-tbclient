package com.baidu.frontia.api;

import com.baidu.frontia.api.FrontiaPushUtil;
import com.baidu.frontia.module.push.FrontiaPushListenerImpl;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public interface FrontiaPushListener {

    /* loaded from: classes.dex */
    public interface CommonMessageListener {
        void onFailure(int i, String str);

        void onSuccess();
    }

    /* loaded from: classes.dex */
    public interface DescribeMessageListener {
        void onFailure(int i, String str);

        void onSuccess(DescribeMessageResult describeMessageResult);
    }

    /* loaded from: classes.dex */
    public class DescribeMessageResult {
        private FrontiaPushListenerImpl.DescribeMessageResult a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public DescribeMessageResult(FrontiaPushListenerImpl.DescribeMessageResult describeMessageResult) {
            this.a = describeMessageResult;
        }

        public String getChannelId() {
            return this.a.getChannelId();
        }

        public JSONObject getExtras() {
            return this.a.getExtras();
        }

        public String getId() {
            return this.a.getId();
        }

        public FrontiaPushUtil.MessageContent getMessage() {
            return new FrontiaPushUtil.MessageContent(this.a.getMessage());
        }

        public String getTag() {
            return this.a.getTag();
        }

        public FrontiaPushUtil.Trigger getTrigger() {
            return new FrontiaPushUtil.Trigger(this.a.getTrigger());
        }

        public String getUserId() {
            return this.a.getUserId();
        }
    }

    /* loaded from: classes.dex */
    public interface ListMessageListener {
        void onFailure(int i, String str);

        void onSuccess(List<DescribeMessageResult> list);
    }

    /* loaded from: classes.dex */
    public interface PushMessageListener {
        void onFailure(int i, String str);

        void onSuccess(String str);
    }
}
