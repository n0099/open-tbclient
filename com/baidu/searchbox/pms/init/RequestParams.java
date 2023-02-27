package com.baidu.searchbox.pms.init;

import android.text.TextUtils;
import com.baidu.searchbox.pms.bean.PackageParams;
import com.baidu.searchbox.pms.callback.IDataInterceptor;
import com.baidu.searchbox.pms.callback.PackageCallback;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.searchbox.pms.utils.CollectionUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class RequestParams {
    public List<Channel> channelList;
    public JSONObject filter;
    public String runNode;
    public String runType;

    /* loaded from: classes2.dex */
    public static class Channel {
        public PackageCallback callback;
        public String channelId;
        public IDataInterceptor dataInterceptor;
        public boolean isFetchAllPackages;
        public boolean isUsePmsVersionData;
        public List<String> packageNames;
        public List<PackageParams> packageParamsList;

        public Channel() {
            this.isUsePmsVersionData = true;
        }

        public PackageCallback getCallback() {
            return this.callback;
        }

        public String getChannelId() {
            return this.channelId;
        }

        public IDataInterceptor getDataInterceptor() {
            return this.dataInterceptor;
        }

        public List<String> getPackageNames() {
            return this.packageNames;
        }

        public List<PackageParams> getPackageParamsList() {
            return this.packageParamsList;
        }

        public boolean isFetchAllPackages() {
            return this.isFetchAllPackages;
        }

        public boolean isUsePmsVersionData() {
            return this.isUsePmsVersionData;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Channel(String str, String str2, PackageCallback packageCallback) {
            this(str, r3, packageCallback);
            List singletonList;
            if (TextUtils.isEmpty(str2)) {
                singletonList = null;
            } else {
                singletonList = Collections.singletonList(str2);
            }
        }

        public Channel(String str, List<String> list, PackageCallback packageCallback) {
            this.isUsePmsVersionData = true;
            this.channelId = str;
            this.packageNames = list;
            this.callback = packageCallback;
            this.packageParamsList = CollectionUtils.convertToPackageParamsList(list);
        }

        public Channel(String str, boolean z, PackageCallback packageCallback) {
            this.isUsePmsVersionData = true;
            this.channelId = str;
            this.isFetchAllPackages = z;
            this.callback = packageCallback;
        }

        public Channel setCallback(PackageCallback packageCallback) {
            this.callback = packageCallback;
            return this;
        }

        public Channel setChannelId(String str) {
            this.channelId = str;
            return this;
        }

        public Channel setDataInterceptor(IDataInterceptor iDataInterceptor) {
            this.dataInterceptor = iDataInterceptor;
            return this;
        }

        public Channel setFetchAllPackages(boolean z) {
            this.isFetchAllPackages = z;
            return this;
        }

        public Channel setPackageNames(List<String> list) {
            this.packageNames = list;
            this.packageParamsList = CollectionUtils.convertToPackageParamsList(list);
            this.isUsePmsVersionData = true;
            return this;
        }

        public Channel setPackageParamsList(List<PackageParams> list) {
            this.packageParamsList = list;
            this.isUsePmsVersionData = false;
            return this;
        }
    }

    public List<Channel> getChannelList() {
        return this.channelList;
    }

    public JSONObject getFilter() {
        return this.filter;
    }

    public String getRunNode() {
        return this.runNode;
    }

    public String getRunType() {
        return this.runType;
    }

    public RequestParams addChannel(Channel channel) {
        if (channel == null) {
            if (!PmsConstant.DEBUG) {
                return this;
            }
            throw new RuntimeException("channel should not be null");
        } else if (!channel.isFetchAllPackages && CollectionUtils.isEmpty(channel.packageParamsList) && channel.dataInterceptor == null) {
            if (!PmsConstant.DEBUG) {
                return this;
            }
            throw new RuntimeException("packageNames should not be empty");
        } else {
            if (this.channelList == null) {
                this.channelList = new ArrayList();
            }
            for (int i = 0; i < this.channelList.size(); i++) {
                Channel channel2 = this.channelList.get(i);
                if (TextUtils.equals(channel2.channelId, channel.channelId)) {
                    if (!PmsConstant.DEBUG) {
                        this.channelList.set(i, channel2);
                        return this;
                    }
                    throw new RuntimeException("请求任务channelId不能重复" + channel2.channelId + "," + channel.channelId);
                }
            }
            this.channelList.add(channel);
            return this;
        }
    }

    public RequestParams setFilter(JSONObject jSONObject) {
        this.filter = jSONObject;
        return this;
    }

    public RequestParams setRunNode(String str) {
        this.runNode = str;
        return this;
    }

    public RequestParams setRunType(String str) {
        this.runType = str;
        return this;
    }
}
