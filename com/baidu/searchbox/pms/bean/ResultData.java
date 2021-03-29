package com.baidu.searchbox.pms.bean;

import java.util.List;
/* loaded from: classes2.dex */
public class ResultData {
    public List<PackageInfo> addList;
    public List<PackageInfo> configChangeList;
    public List<PackageInfo> filterList;
    public List<PackageInfo> invalidList;
    public List<PackageInfo> updateList;

    private void putString(StringBuilder sb, String str, List<PackageInfo> list) {
        sb.append(str);
        sb.append(":");
        sb.append(list.size());
        if (list.size() > 0) {
            sb.append(" [");
            for (int i = 0; i < list.size(); i++) {
                PackageInfo packageInfo = list.get(i);
                if (i == 0) {
                    sb.append(packageInfo.packageName);
                } else {
                    sb.append(",");
                    sb.append(packageInfo.packageName);
                }
            }
            sb.append("]");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        putString(sb, "  addList.size", this.addList);
        putString(sb, "  updateList.size", this.updateList);
        putString(sb, "  configChangeList.size", this.configChangeList);
        putString(sb, "  filterList.size", this.filterList);
        putString(sb, "  invalidList.size", this.invalidList);
        return sb.toString();
    }
}
