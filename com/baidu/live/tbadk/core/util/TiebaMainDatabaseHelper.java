package com.baidu.live.tbadk.core.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.live.adp.base.db.PhoneDatabaseHelper;
/* loaded from: classes6.dex */
public class TiebaMainDatabaseHelper extends PhoneDatabaseHelper {
    public static final int DATABASE_VERSION = 17;
    public static final String TABLE_NAME_LOCAL_GAME = "local_game";

    public TiebaMainDatabaseHelper(Context context) {
        super(context, "baidu_tieba.db", 17);
    }

    @Override // com.baidu.live.adp.base.db.PhoneDatabaseHelper
    public void createAllTables(SQLiteDatabase sQLiteDatabase) {
        try {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists cash_data(type int,account varchar(30),data TEXT)");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists account_data(id,account,password,bduss,isactive int,tbs,time,portrait varchar(255), personal_gid int, gender int, member_iconurl varchar(255),stoken varchar(255))");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists search_data(key, account, time)");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists search_post_data(key, account, time)");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists mark_data(id,floor,time,title,sequence,hostmode,postid,account,authorname,replynum,subPost int,forumName varchar(30),forumId varchar(30),threadId varchar(30))");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists draft_box(account varchar(30),type int,forum_id varchar(20),forum_name TEXT,thread_id varchar(30),floor_id TEXT,title TEXT,content TEXT, time long)");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists setting(account varchar(30),frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone,msg_chat_switch,nodisturb_switch,nodisturb_start_time varchar(30),nodisturb_end_time varchar(30),remind_light,stranger_chat_switch int)");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists chunk_upload_data(account varchar(30),md5,total_length,chunk_no,time)");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists frs_image_forums(forum_name)");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists user_graffiti(pk INTEGER PRIMARY KEY AUTOINCREMENT, uid varchar(30), file_name varchar(128), md5 varchar(128))");
            prepareDBForV7(sQLiteDatabase);
            prepareDBForV11(sQLiteDatabase);
            prepareDBForV12(sQLiteDatabase);
            prepareDBForV16(sQLiteDatabase);
            prepareDBForV17(sQLiteDatabase);
        } catch (Exception e) {
            TiebaInitialize.printDBExceptionLog(e, "DatabaseHelper.createTables", new Object[0]);
        }
    }

    @Override // com.baidu.live.adp.base.db.PhoneDatabaseHelper
    public void clearAllTables(SQLiteDatabase sQLiteDatabase) {
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS cash_data;");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='cash_data';");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS account_data;");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='account_data';");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS search_data;");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='search_data';");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS search_post_data;");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='search_post_data';");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS mark_data;");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='mark_data';");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS draft_box;");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='draft_box';");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS setting;");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='setting';");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS chunk_upload_data;");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='chunk_upload_data';");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS frs_image_forums;");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP INDEX IF EXISTS idx_c_msgs_of;");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='frs_image_forums';");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS chat_msgs;");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP INDEX IF EXISTS idx_c_rfs_ost;");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='chat_msgs';");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS user_emotions");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS emotion_group");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS emotions");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS local_game");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS user_graffiti");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, com.baidu.live.adp.base.db.BdDatabaseHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 1) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists chunk_upload_data(account varchar(30),md5,total_length,chunk_no,time)");
        }
        if (i < 3) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE mark_data ADD subPost int");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE mark_data ADD forumName varchar(30)");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE mark_data ADD forumId varchar(30)");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE mark_data ADD threadId varchar(30)");
        }
        if (i < 4) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE setting ADD remind_tone");
        }
        if (i < 5) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists frs_image_forums(forum_name)");
        }
        if (i < 6) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists search_post_data(key, account, time)");
        }
        if (i < 7) {
            prepareDBForV7(sQLiteDatabase);
        }
        if (i < 8) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE setting ADD msg_chat_switch DEFAULT 1");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE setting ADD nodisturb_switch");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE setting ADD nodisturb_start_time varchar(30)");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE setting ADD nodisturb_end_time varchar(30)");
        }
        if (i < 9) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE account_data ADD portrait varchar(255)");
        }
        if (i < 10) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE account_data ADD personal_gid int");
        }
        if (i < 11) {
            prepareDBForV11(sQLiteDatabase);
        }
        if (i < 12) {
            prepareDBForV12(sQLiteDatabase);
        }
        if (i < 13) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE setting ADD stranger_chat_switch int");
            prepareDBForV13(sQLiteDatabase);
        }
        if (i < 14) {
            prepareDBForV14(sQLiteDatabase);
        }
        if (i < 15) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE account_data ADD stoken varchar(255)");
        }
        if (i < 16) {
            prepareDBForV16(sQLiteDatabase);
        }
        if (i < 17) {
            prepareDBForV17(sQLiteDatabase);
        }
    }

    protected void prepareDBForV7(SQLiteDatabase sQLiteDatabase) {
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists chat_msgs(pk INTEGER primary key autoincrement, msgId bigint,ownerId varchar(32), friendId varchar(32), msgType int(11) default 0, status int(11) default 0, localTime bigint(21) default 0, serverTime bigint(21) default 0, msgContent text)");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE INDEX if not exists idx_c_msgs_of ON chat_msgs(ownerId, friendId, msgId)");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists chat_recent_friends(pk varchar(64) primary key, unReadCount int(11) default 0 ,ownerId varchar(32), friendId varchar(32), ownerName varchar(64), friendName varchar(64), friendPortrait varchar(64), status int(11) default 0, localTime bigint(21) default 0, serverTime bigint(21) default 0, msgContent text)");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE INDEX if not exists idx_c_rfs_ost ON chat_recent_friends(ownerId, serverTime)");
    }

    protected void prepareDBForV11(SQLiteDatabase sQLiteDatabase) {
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, " CREATE TABLE if not exists user_emotions(id INTEGER primary key autoincrement, uid varchar(128), groupId varchar(64), updateTime bigint(21) default 0)");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE INDEX if not exists idx_ue_uid ON user_emotions(uid)");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists emotion_group(groupId varchar(64) primary key, groupName varchar(128), groupDesc text, emotionsCount int(11) default 0, width  int(11) default 0, height  int(11) default 0, status  int(11) default 0, bytesLength int(11) default 0, bytesReceived int(11) default 0, downloadUrl varchar(512), downloadTime bigint(21) default 0)");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE INDEX if not exists idx_eg_gids ON emotion_group(groupId, status)");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists emotions(sharpText varchar(512) primary key, groupId varchar(64), orderId int(11) default 0)");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE INDEX if not exists idx_e_gido ON emotions(groupId, orderId)");
    }

    protected void prepareDBForV12(SQLiteDatabase sQLiteDatabase) {
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists local_game(gameId varchar(64) primary key, gameName varchar(128), gameType int default 0, iconUrl varchar(128), gameLink  varchar(2),packageName varchar(64), launcherActivity  varchar(64),downloadTime varchar(64),installTime varchar(64))");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE setting ADD remind_light int(11) default 1");
    }

    protected void prepareDBForV13(SQLiteDatabase sQLiteDatabase) {
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE account_data ADD gender int");
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE account_data ADD member_iconurl varchar(255)");
    }

    protected void prepareDBForV14(SQLiteDatabase sQLiteDatabase) {
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists user_graffiti(pk INTEGER PRIMARY KEY AUTOINCREMENT, uid varchar(30), file_name varchar(128), md5 varchar(128))");
    }

    protected void prepareDBForV16(SQLiteDatabase sQLiteDatabase) {
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists user_collect_emotion(pid varchar(30), uid varchar(30), sharp_text varchar(256), order_id int, width int, height int, pic_url varchar(512), thumbnail varchar(512), backup TEXT, primary key(pid, uid))");
    }

    protected void prepareDBForV17(SQLiteDatabase sQLiteDatabase) {
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE setting ADD zan_me_switch int");
    }
}
