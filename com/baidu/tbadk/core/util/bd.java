package com.baidu.tbadk.core.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class bd extends com.baidu.adp.base.a.c {
    public bd(Context context) {
        super(context, TbConfig.PHONE_DATEBASE_NAME, 15);
    }

    @Override // com.baidu.adp.base.a.c
    public void c(SQLiteDatabase sQLiteDatabase) {
        try {
            b(sQLiteDatabase, "CREATE TABLE if not exists cash_data(type int,account varchar(30),data TEXT)");
            b(sQLiteDatabase, "CREATE TABLE if not exists account_data(id,account,password,bduss,isactive int,tbs,time,portrait varchar(255), personal_gid int, gender int, member_iconurl varchar(255),stoken varchar(255))");
            b(sQLiteDatabase, "CREATE TABLE if not exists search_data(key, account, time)");
            b(sQLiteDatabase, "CREATE TABLE if not exists search_post_data(key, account, time)");
            b(sQLiteDatabase, "CREATE TABLE if not exists mark_data(id,floor,time,title,sequence,hostmode,postid,account,authorname,replynum,subPost int,forumName varchar(30),forumId varchar(30),threadId varchar(30))");
            b(sQLiteDatabase, "CREATE TABLE if not exists draft_box(account varchar(30),type int,forum_id varchar(20),forum_name TEXT,thread_id varchar(30),floor_id TEXT,title TEXT,content TEXT, time long)");
            b(sQLiteDatabase, "CREATE TABLE if not exists setting(account varchar(30),frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone,msg_chat_switch,nodisturb_switch,nodisturb_start_time varchar(30),nodisturb_end_time varchar(30),remind_light,stranger_chat_switch int)");
            b(sQLiteDatabase, "CREATE TABLE if not exists chunk_upload_data(account varchar(30),md5,total_length,chunk_no,time)");
            b(sQLiteDatabase, "CREATE TABLE if not exists frs_image_forums(forum_name)");
            b(sQLiteDatabase, "CREATE TABLE if not exists user_graffiti(pk INTEGER PRIMARY KEY AUTOINCREMENT, uid varchar(30), file_name varchar(128), md5 varchar(128))");
            i(sQLiteDatabase);
            j(sQLiteDatabase);
            k(sQLiteDatabase);
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "DatabaseHelper.createTables", new Object[0]);
        }
    }

    @Override // com.baidu.adp.base.a.c
    public void d(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase, "DROP TABLE IF EXISTS cash_data;");
        b(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='cash_data';");
        b(sQLiteDatabase, "DROP TABLE IF EXISTS account_data;");
        b(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='account_data';");
        b(sQLiteDatabase, "DROP TABLE IF EXISTS search_data;");
        b(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='search_data';");
        b(sQLiteDatabase, "DROP TABLE IF EXISTS search_post_data;");
        b(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='search_post_data';");
        b(sQLiteDatabase, "DROP TABLE IF EXISTS mark_data;");
        b(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='mark_data';");
        b(sQLiteDatabase, "DROP TABLE IF EXISTS draft_box;");
        b(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='draft_box';");
        b(sQLiteDatabase, "DROP TABLE IF EXISTS setting;");
        b(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='setting';");
        b(sQLiteDatabase, "DROP TABLE IF EXISTS chunk_upload_data;");
        b(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='chunk_upload_data';");
        b(sQLiteDatabase, "DROP TABLE IF EXISTS frs_image_forums;");
        b(sQLiteDatabase, "DROP INDEX IF EXISTS idx_c_msgs_of;");
        b(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='frs_image_forums';");
        b(sQLiteDatabase, "DROP TABLE IF EXISTS chat_msgs;");
        b(sQLiteDatabase, "DROP INDEX IF EXISTS idx_c_rfs_ost;");
        b(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='chat_msgs';");
        b(sQLiteDatabase, "DROP TABLE IF EXISTS user_emotions");
        b(sQLiteDatabase, "DROP TABLE IF EXISTS emotion_group");
        b(sQLiteDatabase, "DROP TABLE IF EXISTS emotions");
        b(sQLiteDatabase, "DROP TABLE IF EXISTS local_game");
        b(sQLiteDatabase, "DROP TABLE IF EXISTS user_graffiti");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, com.baidu.adp.base.a.a
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 1) {
            b(sQLiteDatabase, "CREATE TABLE if not exists chunk_upload_data(account varchar(30),md5,total_length,chunk_no,time)");
        }
        if (i < 3) {
            b(sQLiteDatabase, "ALTER TABLE mark_data ADD subPost int");
            b(sQLiteDatabase, "ALTER TABLE mark_data ADD forumName varchar(30)");
            b(sQLiteDatabase, "ALTER TABLE mark_data ADD forumId varchar(30)");
            b(sQLiteDatabase, "ALTER TABLE mark_data ADD threadId varchar(30)");
        }
        if (i < 4) {
            b(sQLiteDatabase, "ALTER TABLE setting ADD remind_tone");
        }
        if (i < 5) {
            b(sQLiteDatabase, "CREATE TABLE if not exists frs_image_forums(forum_name)");
        }
        if (i < 6) {
            b(sQLiteDatabase, "CREATE TABLE if not exists search_post_data(key, account, time)");
        }
        if (i < 7) {
            i(sQLiteDatabase);
        }
        if (i < 8) {
            b(sQLiteDatabase, "ALTER TABLE setting ADD msg_chat_switch DEFAULT 1");
            b(sQLiteDatabase, "ALTER TABLE setting ADD nodisturb_switch");
            b(sQLiteDatabase, "ALTER TABLE setting ADD nodisturb_start_time varchar(30)");
            b(sQLiteDatabase, "ALTER TABLE setting ADD nodisturb_end_time varchar(30)");
        }
        if (i < 9) {
            b(sQLiteDatabase, "ALTER TABLE account_data ADD portrait varchar(255)");
        }
        if (i < 10) {
            b(sQLiteDatabase, "ALTER TABLE account_data ADD personal_gid int");
        }
        if (i < 11) {
            j(sQLiteDatabase);
        }
        if (i < 12) {
            k(sQLiteDatabase);
        }
        if (i < 13) {
            b(sQLiteDatabase, "ALTER TABLE setting ADD stranger_chat_switch int");
            l(sQLiteDatabase);
        }
        if (i < 14) {
            m(sQLiteDatabase);
        }
        if (i < 15) {
            b(sQLiteDatabase, "ALTER TABLE account_data ADD stoken varchar(255)");
        }
    }

    protected void i(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase, "CREATE TABLE if not exists chat_msgs(pk INTEGER primary key autoincrement, msgId bigint,ownerId varchar(32), friendId varchar(32), msgType int(11) default 0, status int(11) default 0, localTime bigint(21) default 0, serverTime bigint(21) default 0, msgContent text)");
        b(sQLiteDatabase, "CREATE INDEX if not exists idx_c_msgs_of ON chat_msgs(ownerId, friendId, msgId)");
        b(sQLiteDatabase, "CREATE TABLE if not exists chat_recent_friends(pk varchar(64) primary key, unReadCount int(11) default 0 ,ownerId varchar(32), friendId varchar(32), ownerName varchar(64), friendName varchar(64), friendPortrait varchar(64), status int(11) default 0, localTime bigint(21) default 0, serverTime bigint(21) default 0, msgContent text)");
        b(sQLiteDatabase, "CREATE INDEX if not exists idx_c_rfs_ost ON chat_recent_friends(ownerId, serverTime)");
    }

    protected void j(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase, " CREATE TABLE if not exists user_emotions(id INTEGER primary key autoincrement, uid varchar(128), groupId varchar(64), updateTime bigint(21) default 0)");
        b(sQLiteDatabase, "CREATE INDEX if not exists idx_ue_uid ON user_emotions(uid)");
        b(sQLiteDatabase, "CREATE TABLE if not exists emotion_group(groupId varchar(64) primary key, groupName varchar(128), groupDesc text, emotionsCount int(11) default 0, width  int(11) default 0, height  int(11) default 0, status  int(11) default 0, bytesLength int(11) default 0, bytesReceived int(11) default 0, downloadUrl varchar(512), downloadTime bigint(21) default 0)");
        b(sQLiteDatabase, "CREATE INDEX if not exists idx_eg_gids ON emotion_group(groupId, status)");
        b(sQLiteDatabase, "CREATE TABLE if not exists emotions(sharpText varchar(512) primary key, groupId varchar(64), orderId int(11) default 0)");
        b(sQLiteDatabase, "CREATE INDEX if not exists idx_e_gido ON emotions(groupId, orderId)");
    }

    protected void k(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase, "CREATE TABLE if not exists local_game(gameId varchar(64) primary key, gameName varchar(128), gameType int default 0, iconUrl varchar(128), gameLink  varchar(2),packageName varchar(64), launcherActivity  varchar(64),downloadTime varchar(64),installTime varchar(64))");
        b(sQLiteDatabase, "ALTER TABLE setting ADD remind_light int(11) default 1");
    }

    protected void l(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase, "ALTER TABLE account_data ADD gender int");
        b(sQLiteDatabase, "ALTER TABLE account_data ADD member_iconurl varchar(255)");
    }

    protected void m(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase, "CREATE TABLE if not exists user_graffiti(pk INTEGER PRIMARY KEY AUTOINCREMENT, uid varchar(30), file_name varchar(128), md5 varchar(128))");
    }
}
