package com.baidu.searchbox.network.outback.statistics;
/* loaded from: classes2.dex */
public interface IAdditionalRecord {
    public static final IAdditionalRecord EMPTY = new IAdditionalRecord() { // from class: com.baidu.searchbox.network.outback.statistics.IAdditionalRecord.1
        @Override // com.baidu.searchbox.network.outback.statistics.IAdditionalRecord
        public long getAppLaunchTimeStamp() {
            return 0L;
        }

        @Override // com.baidu.searchbox.network.outback.statistics.IAdditionalRecord
        public String getClientIPV6() {
            return null;
        }

        @Override // com.baidu.searchbox.network.outback.statistics.IAdditionalRecord
        public String getHttpDnsAreaInfo() {
            return null;
        }

        @Override // com.baidu.searchbox.network.outback.statistics.IAdditionalRecord
        public long getHttpDnsAreaInfoLastUpdateTime() {
            return 0L;
        }

        @Override // com.baidu.searchbox.network.outback.statistics.IAdditionalRecord
        public int getIpStack() {
            return 0;
        }

        @Override // com.baidu.searchbox.network.outback.statistics.IAdditionalRecord
        public int getNetworkQuality() {
            return 1;
        }

        @Override // com.baidu.searchbox.network.outback.statistics.IAdditionalRecord
        public String getProcessName() {
            return null;
        }
    };

    long getAppLaunchTimeStamp();

    String getClientIPV6();

    String getHttpDnsAreaInfo();

    long getHttpDnsAreaInfoLastUpdateTime();

    int getIpStack();

    int getNetworkQuality();

    String getProcessName();
}
