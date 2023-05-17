package com.baidu.searchbox.cloudcommand.dao;
/* loaded from: classes3.dex */
public class CloudCommandTable {
    public static final String CREATE_TABLE = "create table cloudcommand(msgId text primary key,type text ,dispatched integer,version text,timestamp integer)";
    public static final String DISPATCHED = "dispatched";
    public static final int IS_DISPATCHED = 1;
    public static final String MSG_ID = "msgId";
    public static final String TABLE_NAME = "cloudcommand";
    public static final String TIMESTAMP = "timestamp";
    public static final String TYPE = "type";
    public static final String VERSION = "version";
}
